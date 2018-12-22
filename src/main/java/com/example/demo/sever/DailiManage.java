package com.example.demo.sever;

import com.example.demo.bean.*;
import com.example.demo.mapper.DailiManageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DailiManage {

    @Autowired
    DailiManageDao dailiManageDao;

    //查询所有的代理商品
    @Transactional
    public List<Goods> lookAllGoods(int id){
      List<FDG> fdgs = dailiManageDao.findFactoryDaili(id);
        ArrayList<Goods> goods =new  ArrayList<Goods>();
        for(FDG fdg:fdgs) {
            int i=fdg.getShangpingId();
            Goods good=dailiManageDao.findGoods(i);
            goods.add(good);
        }
      return  goods;

    }
    //通过商品id查询厂商
    @Transactional
    public FUser lookFactory(int id){

       return dailiManageDao.findFactory(id);

    }

    //代理商将商品出售
    @Transactional
    public void goodsSell(FDG fdg, GoodSell goodSell){
       int i= dailiManageDao.findFactoryDailiId(fdg);
       goodSell.setFactorydailliId(i);
        dailiManageDao.insertGoodsSell(goodSell);
    }

    //代理商查询已经发布的商品
    @Transactional
    public List<AllInfo> AllfabuGoods(int dailiid) {
        return dailiManageDao.findSellGoods(dailiid);
    }


    //查询所有没有发布的商品
    @Transactional
    public List<Goods> AllNFabGoods(int dailiid) {
       List<Goods> goods=this.lookAllGoods(dailiid);
       List<AllInfo> allInfos=this.AllfabuGoods(dailiid);
        for(Goods good:goods) {
           int a = good.getId();
            for(AllInfo allInfo:allInfos) {
                int b=allInfo.getShangpingId();
                    if(a==b){
                        goods.remove(good);
                    }
            }
        }
        return goods;
    }

}