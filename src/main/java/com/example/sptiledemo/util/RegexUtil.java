package com.example.sptiledemo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    /**
     * 正则解析页面工具类
     * @param content   页面内容
     * @param regex     过滤正则表达式
     * @return
     */
    public static String getFileByRegex(String content,String regex){
        Matcher matcher = Pattern.compile(regex).matcher(content);
        if(matcher.find()){
            return matcher.group();
        }
        return "0";
    }
}
