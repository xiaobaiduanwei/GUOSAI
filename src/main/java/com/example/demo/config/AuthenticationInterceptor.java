package com.example.demo.config;

import com.example.demo.bean.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        StringBuffer url = httpServletRequest.getRequestURL();
        System.out.println(url);
        if (token != null && !token.isEmpty()) {
            final UserBase user = jwtTokenUtil.parse(token.trim());
            String role = user.getRole();
            //   StringBuffer url = httpServletRequest.getRequestURL();


            if (url.toString().contains("admin")) {
                if (!(user.getRole().equals("admin"))) {
                    throw new RuntimeException("权限不足");
                }

                return true;
            }
            if (url.toString().contains("factory")) {
                if (!((user.getRole().equals("admin")) || (user.getRole().equals("factory")))) {
                    throw new RuntimeException("权限不足");
                }

                return true;
            }
            if (url.toString().contains("daili")) {
                if (!((user.getRole().equals("admin")) || (user.getRole().equals("daili")))) {
                    throw new RuntimeException("权限不足");
                }

                return true;
            }
        } else {
            throw new RuntimeException("没有token");
        }
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, 
                                  HttpServletResponse httpServletResponse, 
                            Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, 
                                          HttpServletResponse httpServletResponse, 
                                          Object o, Exception e) throws Exception {
    }
    }