package com.example.demo.controller;

import com.example.demo.bean.FUser;
import com.example.demo.bean.Massage;
import com.example.demo.sever.ApplyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ApplyController {


    @Autowired
    ApplyServer applyServer;

    @GetMapping("/lookFactory")
    @ResponseBody
    public List<FUser> lookFactory() throws  RuntimeException {
        List<FUser> fUsersall;

             fUsersall=  applyServer.lookApplyFactory();

        return  fUsersall;


    }

    @GetMapping("/accept/{username}")
    @ResponseBody
    public Massage approve(@PathVariable("username") String u) {

        try {
            applyServer.appendFactory(u);
        } catch (Exception e) {

            e.printStackTrace();
            return new Massage(700,"执行错误");
        }

        return new Massage(800,"执行成功");

    }





}

