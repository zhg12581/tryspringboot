package com.example.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author zhu
 * @date 2019/10/19
 **/
//自定义异常数据
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String,Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace){
        //获取springboot提供的默认错误信息
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest,includeStackTrace);
        //增加错误信息
        errorAttributes.put("custommsg","出错了");
        //删除key为error的错误信息
       // errorAttributes.remove("error");
        return errorAttributes;
    }


}
