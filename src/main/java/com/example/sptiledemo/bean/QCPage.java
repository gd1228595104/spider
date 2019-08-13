package com.example.sptiledemo.bean;

import org.springframework.context.annotation.Configuration;

/**
 * 万和IT实体类
 */
@Configuration
public class QCPage {
    /**
     * 页面内容
     */
    private String content;
    /**
     * 职位
     */
    private String job;
    /**
     *公司
     */
    private String company;
    /**
     * 地点
     */
    private String place;
    /**
     * 工资
     */
    private String salar;
    /**
     *  日期
     */
    private String date;
    /**
     * 网页地址
     */
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSalar() {
        return salar;
    }

    public void setSalar(String salar) {
        this.salar = salar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void set(String job, String company, String place,String salar, String date){
        this.setJob(job);
        this.setCompany(company);
        this.setPlace(place);
        this.setSalar(salar);
        this.setDate(date);
    }

    @Override
    public String toString() {
        return "QCPage{" +
                ", job='" + job + '\'' +
                ", company='" + company + '\'' +
                ", place='" + place + '\'' +
                ", salar='" + salar + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
