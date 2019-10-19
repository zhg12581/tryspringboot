package com.example.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhu
 * @date 2019/10/19
 *  * 返回string或者json需要@ResponseBody
 *  * 用RestControllerAdvice，就不用加@ResponseBody了
 **/

@RestControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }

    @ExceptionHandler({ IndexOutOfBoundsException.class })
    public String handleIndexOutOfBoundsException(Exception e) {
        e.printStackTrace();
        return "testArrayIndexOutOfBoundsException";
    }

    @ExceptionHandler(value = BusinessException.class)
    public Map<String,Object> errorHandle(BusinessException e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        return map;
    }



}
