package com.example.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhu
 * @date 2019/10/19
 **/
//定义全局数据
@ControllerAdvice
public class GlobalConfig {
    @ModelAttribute(value = "msg")
    public String message() {
        return "欢迎访问 hangge.com";
    }

    @ModelAttribute(value = "info")
    public Map<String, String> userinfo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "hangge");
        map.put("age", "100");
        return map;
    }

    //请求参数预处理
    @InitBinder("author")
    public void init1(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("author.");
    }
    @InitBinder("book")
    public void init2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("book.");
    }

}
