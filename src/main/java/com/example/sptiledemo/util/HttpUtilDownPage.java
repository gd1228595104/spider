package com.example.sptiledemo.util;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HttpUtilDownPage {
    //新建一个模拟谷歌Chrome浏览器的浏览器客户端对象
    private static final WebClient webClient = new WebClient(BrowserVersion.CHROME);

    public static String sendGet(){
        //当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        //当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        //是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setCssEnabled(false);
        //很重要，启用JS
        webClient.getOptions().setJavaScriptEnabled(true);
        //很重要，设置支持AJAX
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = null;
        try {
            page = webClient.getPage("https://search.51job.com/list/040000,000000,0000,00,9,99,Java,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            webClient.close();
        }
        //异步JS执行需要耗时,所以这里线程要阻塞30秒,等待异步JS执行结束
        webClient.waitForBackgroundJavaScript(30000);
        //直接将加载完成的页面转换成xml格式的字符串
        String pageXml = page.asXml();
        return pageXml;
    }
}
