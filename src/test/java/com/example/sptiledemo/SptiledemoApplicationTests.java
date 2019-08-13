package com.example.sptiledemo;

import com.example.sptiledemo.bean.Page;
import com.example.sptiledemo.service.PageDownLoad;
import com.example.sptiledemo.service.ProcessService;
import com.example.sptiledemo.util.HttpUtilDownPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SptiledemoApplicationTests {
    @Value("${douban.url}")
    private String url;
    @Autowired
    private ProcessService processService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
//        processService.process(url);
//        redisTemplate.opsForValue().set("test","Hello");
//        redisTemplate.boundListOps("test").leftPush("Helo");
        redisTemplate.opsForList().leftPush("test","java");
        System.out.println(redisTemplate.opsForList().leftPop("test"));
    }

}
