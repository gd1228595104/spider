package com.example.sptiledemo.service.impl;

import com.example.sptiledemo.bean.Page;
import com.example.sptiledemo.service.PageDownLoad;
import com.example.sptiledemo.util.HttpClientDownPage;
import org.springframework.stereotype.Service;

@Service
public class PageDownLoadImpl implements PageDownLoad {
    @Override
    public Page downPage(String url) {
        String conetent = HttpClientDownPage.sendGet(url);
        System.out.println(url);
        Page page = new Page();
        page.setContent(conetent);
        return page;
    }
}
