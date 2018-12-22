package com.example.demo.controller;

import com.example.demo.bean.FUser;
import com.example.demo.bean.Goods;
import com.example.demo.bean.Massage;
import com.example.demo.sever.ApplyServer;
import com.example.demo.sever.GoodServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factory")
public class GoodsController {


    @Autowired
    GoodServer goodServer;
    @Autowired
    ApplyServer applyServer;
    //厂商添加商品
    @GetMapping("/addgoods/{goods}")
    @ResponseBody
    public Massage addGoods(@PathVariable("goods") Goods goods) throws  Exception{
        goodServer.goodAppend(goods,"dd");

        return  new Massage(800,"成功");
    }
    //通过厂家的名字查询他旗下的所有商品
    @GetMapping("/findgoods/{goodsname}")
    @ResponseBody
    public List<Goods> findGoods(@PathVariable("goodsname") String goodsname) throws  Exception{

                return goodServer.findGoodsByFactory(goodsname);
    }
    //查询所有的厂商
    @GetMapping("/findfactory")
    @ResponseBody
    public List<FUser> findGoods() throws  Exception{

        return applyServer.lookFactory();
    }
    //删除商品
    @GetMapping("/removegoods/{id}")
    @ResponseBody
    public Massage findGoods(@PathVariable("id") int id) throws  Exception{
        goodServer.deleteGoods(id);
        return  new Massage(800,"执行成功");
    }
}
