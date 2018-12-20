package com.example.demo.controller;

import com.example.demo.bean.FDG;
import com.example.demo.bean.Massage;
import com.example.demo.sever.GoodsDaiLiServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DaiLiController {
    @Autowired
    GoodsDaiLiServer goodsDaiLiServer;
    //代理申请，当代理商申请代理时调用 传入参数fdg   fdg中包括厂商id，代理商id，商品id
    @GetMapping("/daili/applydaili/{fdg}")
    @ResponseBody
    public Massage applyDaiLi(@PathVariable("fdg") FDG fdg) throws  Exception{

        goodsDaiLiServer.applyDailiGoods(fdg);
     return new Massage(800,"成功");
    }
    //厂商查看它的代理申请
    @GetMapping("/factory/lookdaili/{id}")
    @ResponseBody
    public List<Massage> lookDaili(@PathVariable("id") int id) throws  Exception{


        return goodsDaiLiServer.factoryLookApply(id);
    }

    //厂商接受的代理申请
    @GetMapping("/factory/acceptapply/{fdg}")
    @ResponseBody
    public Massage acceptDaili(@PathVariable("fdg") FDG fdg ) throws  Exception{

        goodsDaiLiServer.factoryAcceptApply(fdg);

        return new Massage(800,"成功");
    }
    //厂商拒绝代理请求
    @GetMapping("/factory/refuseapply/{fdg}")
    @ResponseBody
    public Massage refuseDaili(@PathVariable("fdg") FDG fdg) throws  Exception{
        goodsDaiLiServer.factoryRefuseApply(fdg);

        return new Massage(800,"成功");
    }

    //代理商查看它的被拒绝的申请
    @GetMapping("/daili/lookrefuse/{id}")
    @ResponseBody
    public List<Massage> dailiLookRefuse(@PathVariable("id") int id) throws  Exception{


        return goodsDaiLiServer.dailiLookNote(id);
    }

}
