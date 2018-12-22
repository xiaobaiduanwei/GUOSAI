package com.example.demo.sever;

import com.example.demo.bean.*;
import com.example.demo.mapper.GoodsDaiLiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsDaiLiServer {
    @Autowired
    GoodsDaiLiDao goodsDaiLiDao;
    //申请代理商品
    public  void applyDailiGoods(FDG fdg) throws  Exception{

        goodsDaiLiDao.insertFactoryDailiApply(fdg);

    }
    //厂商查看所有申请信息
    @Transactional
    public   List<Massage>  factoryLookApply(int id) throws  Exception{
        List<FDG> fdgs = goodsDaiLiDao.findDailiApplyById(id);
        ArrayList<Massage> massages= new  ArrayList<Massage>();
        for(FDG fdg:fdgs) {
            DUser duser = goodsDaiLiDao.findDaiLiById(fdg.getDailiid());
            Goods goods = goodsDaiLiDao.findGoodsById(fdg.getShangpingId());
            String s = duser.getUserName()+"**"+duser.getId()+""+"想代理"+ "你的" +  goods.getShangpingName()+"**"+goods.getId()+"" +"的商品";
            Massage massage= new Massage(800, s );
            massages.add(massage);
        }
        return massages;
    }

    //厂商接受代理申请
    @Transactional
    public  void factoryAcceptApply(FDG fdg) throws  Exception{

        goodsDaiLiDao.deleteFactoryDailiApply(fdg);
        goodsDaiLiDao.insertFactoryDaili(fdg);}


    //厂商拒接代理申请
    @Transactional
    public  void factoryRefuseApply(FDG fdg) throws  Exception{
        goodsDaiLiDao.deleteFactoryDailiApply(fdg);
        goodsDaiLiDao.insertNote(fdg);
       }

    //代理查看被拒绝的记录
    @Transactional
    public List<Massage> dailiLookNote(int id) throws  Exception{
        List<FDG> fdgs=goodsDaiLiDao.findNoteByDailiId(id);
        ArrayList<Massage> massages= new  ArrayList<Massage>();
        for(FDG fdg:fdgs) {
            FUser fuser = goodsDaiLiDao.findFactoryById(fdg.getChangshangid());
            Goods goods = goodsDaiLiDao.findGoodsById(fdg.getShangpingId());
            String s="你在代理"+ fuser.getUserName() + "的商品" + goods.getShangpingName() + "时被拒绝";
            Massage massage= new Massage(800, s );
            massages.add(massage);
        }
        return massages;
    }
}
