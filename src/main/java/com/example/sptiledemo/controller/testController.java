package com.example.sptiledemo.controller;

import com.example.sptiledemo.bean.Page;
import com.example.sptiledemo.service.PageDownLoad;
import com.example.sptiledemo.service.ProcessService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @Autowired
    private ProcessService processService;
    @GetMapping("infoList")
    public String test(int pageNum, int pageSize){
        return processService.selectAll(pageNum,pageSize);
    }
    @GetMapping("spiter")
    public String test2(){
        processService.process();
        return "SUCCESS";
    }
}
