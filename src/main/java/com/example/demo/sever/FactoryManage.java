package com.example.demo.sever;

import com.example.demo.bean.DUser;
import com.example.demo.bean.FDG;
import com.example.demo.bean.Goods;
import com.example.demo.mapper.FactoryManageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactoryManage {
    @Autowired
    FactoryManageDao factoryManageDao;
    //查询所有的代理商
    @Transactional
    public List<DUser> lookAllDaili(int id){
        List<FDG> fdgs = factoryManageDao.findFactoryDaili(id);
        ArrayList<DUser> duseres =new  ArrayList<DUser>();
        for(FDG fdg:fdgs) {
            int i=fdg.getDailiid();
            DUser duser=factoryManageDao.findDaili(i);
            duseres.add(duser);
        }
        return  duseres;

    }
    //查询代理商代理的商品
    @Transactional
    public List<Goods> lookDailiAllGoods(int csid, int dlid){
        List<FDG> fdgs = factoryManageDao.findFactoryDaili(csid);
        ArrayList<Goods> goods =new  ArrayList<Goods>();
        for(FDG fdg:fdgs) {
            int i=fdg.getDailiid();
            if(i==dlid){
                 Goods good=factoryManageDao.findGoods(i);
                 goods.add(good);
            }
        }
        return  goods;

    }






}
