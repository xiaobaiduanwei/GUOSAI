package com.example.demo.mapper;

import com.example.demo.bean.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DailiManageDao {
    //通过代理id查询 所有的fdg
   List<FDG> findFactoryDaili(int id);
    //通过商品id查询商品信息
    Goods findGoods(int id);
    //通过商品id查询厂商
    FUser findFactory(int id);
    //通过fdg删除fdg
    void deleteFactorydaili(FDG fdg);
    //通过fdg查看fdg的id
    int  findFactoryDailiId(FDG fdg);
    //在goodssell中添加数据
    void insertGoodsSell(GoodSell goodSell);
    //通过代理id查询所有已经发布的商品的信息（商品售价，商品描述，商品的照片地址，商品id，厂商id）
    List<AllInfo>findSellGoods(int dailiid);
}
