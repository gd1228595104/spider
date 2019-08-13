package com.example.sptiledemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.sptiledemo.api.Response;
import com.example.sptiledemo.bean.QCPage;
import com.example.sptiledemo.dao.QcspiterMapper;
import com.example.sptiledemo.service.ProcessService;
import com.example.sptiledemo.util.HttpClientDownPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QCProcessServiceImpl implements ProcessService {
    @Value("${douban.url}")
    private String url;
    @Autowired
    QcspiterMapper qcspiterMapper;
    //存储地址队列
//    private Queue<String> queue = new ConcurrentLinkedDeque<>();
    /**
     * redis操作类
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 创建QCPage数组用于存储解析下来的实体
     */
    private  List<QCPage> list = new ArrayList<>();
    /**
     * 测试阶段用于控制数据爬取数量，之后设置了定时，也就没改了。
     */
    private int result = 1;
    @Override
    public void process() {
        //将首地址存入队列
//        queue.add(url);
        //将首地址存入Redis中
        while(true) {
//            String nexturl = queue.poll();
            //从redis获取地址
            String nexturl = stringRedisTemplate.opsForList().rightPop("url");
            if(StringUtils.isNotBlank(nexturl)) {
                //通过HttpClient请求页面，获取网页源码进行解析
                String content = HttpClientDownPage.sendGet(nexturl);
                //通过Jsoup进行页面解析
                Document document = Jsoup.parse(content);
                paraseList(document);
                qcspiterMapper.save(list);
                list = new ArrayList<>();
            }
            if(result > 500) {
                break;
            }
        }
        System.out.println("-----结束----");
    }

    /**
     * 查找数据库列表所有信息
     * @return
     */
    @Override
    public String selectAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<QCPage> infoList = qcspiterMapper.selectAll();
        int count = qcspiterMapper.selectCount();
        return JSON.toJSONString(new Response(infoList,count));
    }

    /**
     * 解析职位列表框
     * @param document
     */
    private void paraseList(Document document){
        //根据网页标签解析源码
        Elements elements = document.select("#resultList .el");
        //去除表头
        elements.remove(0);
        for(Element element:elements){
            Elements elements1 = element.select("span");
            QCPage qcPage = new QCPage();
            qcPage.set(elements1.get(0).text(),elements1.get(1).text(),elements1.get(2).text(),elements1.get(3).text(),elements1.get(4).text());
            //将解析后的实体放入集合中
            list.add(qcPage);
            System.out.println(result+" : " +qcPage);
            result+=1;
        }
        /**
         * 这里解析下一页地址的标签，获取下一页的Url,然后放在redis中
         */
        Elements elements1 = document.select("li[class=bk]").select("a");
        for(Element element:elements1){
            String url = element.attr("href");
            if(StringUtil.isNotBlank(url)){
                stringRedisTemplate.opsForList().leftPush("url",url);
            }
        }
    }

    /**
     * 定时任务，每60秒添加一次首页地址
     */
    @Scheduled(cron = "0/60 * * * * MON-SAT")
    public void adUrl(){
        stringRedisTemplate.opsForList().leftPush("url",url);
        System.out.println("************添加一次地址**************");
    }

}
