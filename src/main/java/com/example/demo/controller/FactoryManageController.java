package com.example.demo.controller;

import com.example.demo.bean.DUser;
import com.example.demo.bean.Goods;
import com.example.demo.sever.FactoryManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factory")
public class FactoryManageController {

    @Autowired
    FactoryManage factoryManage;
    //厂商商通过它的id查询它所代理商
    @GetMapping("lookalldaili/{id}")
    @ResponseBody
    public List<DUser> lookAllDaili(@PathVariable("id") int id) throws  Exception{

        return factoryManage.lookAllDaili(id);
    }
    //通过商品id查询厂商
    @GetMapping("lookdailigoods/{csid}/{dlid}")
    @ResponseBody
    public List<Goods> lookDailiGoods(@PathVariable("csid") int csid, @PathVariable("dlid") int dlid) throws  Exception{

        return factoryManage.lookDailiAllGoods(csid,dlid);
    }

}
