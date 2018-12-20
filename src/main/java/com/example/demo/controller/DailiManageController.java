package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.sever.DailiManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daili")
public class DailiManageController {


    @Autowired
    DailiManage dailiManage;
    //代理商通过它的id查询它所代理的所有商品
    @GetMapping("lookallgoods/{id}")
    @ResponseBody
    public List<Goods> lookAllGoods(@PathVariable("id") int id) throws  Exception{

        return dailiManage.lookAllGoods(id);
    }
    //通过商品id查询厂商
    @GetMapping("lookfactory/{id}")
    @ResponseBody
    public FUser lookFactory(@PathVariable("id") int id) throws  Exception{

        return dailiManage.lookFactory(id);
    }


    //添加fdg和goodeSell将商品出售goodeSell里包含了代理商在商品出售时所定的售价和对商品的描述
    @GetMapping("goodsSeller /{fdg}/{goodSell}")
    @ResponseBody
    public Massage goodsSeller(@PathVariable("fdg") FDG fdg , @PathVariable("goodSell") GoodSell goodSell) throws  Exception{



        dailiManage.goodsSell(fdg,goodSell);
        return new Massage(800,"成功");
    }

    //通过代理商id查询正在出售商品的一系列信息
    @GetMapping("lookallsellgoods/{dailiid}")
    @ResponseBody
    public List<AllInfo> lookAllSellGoods(@PathVariable("dailiid") int dailiid ) throws  Exception{

        return  dailiManage.AllfabuGoods(dailiid);
    }

    //通过代理商id查询代理了但是没有出售的商品
    @GetMapping("lookallnosellgoods/{dailiid}")
    @ResponseBody
    public List<Goods> lookAllNoSellGoods(@PathVariable("dailiid") int dailiid ) throws  Exception{

      return dailiManage.AllNFabGoods(dailiid);
    }

}
