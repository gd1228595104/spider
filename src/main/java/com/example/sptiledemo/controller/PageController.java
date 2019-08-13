package com.example.sptiledemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("getInfoList")
    public String index(){
        return "index";
    }
}
