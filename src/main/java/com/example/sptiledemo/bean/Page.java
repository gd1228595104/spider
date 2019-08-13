package com.example.sptiledemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储页面的实体类
 * @author Dawn
 */
public class Page {
    /**
     * 网页内容
     */
    private String content;
    /**
     * 评论数
     */
    private String commentNum;
    /**
     * 影视名称
     */
    private String TVName;
    /**
     * 页面地址
     */
    private String url;

    /**
     * 页面地址集合
     */
    private List<String> surlList = new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getTVName() {
        return TVName;
    }

    public void setTVName(String TVName) {
        this.TVName = TVName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getSurlList() {
        return surlList;
    }
}
