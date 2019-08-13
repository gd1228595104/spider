package com.example.sptiledemo.service;

import com.example.sptiledemo.bean.Page;
import com.example.sptiledemo.bean.QCPage;

import java.util.List;

/**
 * 页面解析接口
 * @author Dawn
 */
public interface ProcessService {
    public void process();
    public String selectAll(int pageNum,int pageSize);
}
