package com.example.demo.config;


import com.example.demo.bean.Massage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Massage defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        System.out.println("=====================全局异常信息捕获=======================");
        System.out.println(ex);
        String msg;
        if (ex instanceof RuntimeException) {

            msg = ex.getMessage();
            if (msg.equals("没有token")) {
                return new Massage(1000, msg);
            }
            if (msg.equals("权限不够")) {
                return new Massage(1100, msg);
            }

            return new Massage(1200, "操作错误");
        }
       else if(ex instanceof NullPointerException){
           return  new Massage(1600,"为空");

        }
       else {

            return new Massage(1200, "操作错误");
        }


    }
}