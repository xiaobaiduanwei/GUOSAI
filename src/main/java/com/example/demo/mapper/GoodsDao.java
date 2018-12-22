package com.example.demo.mapper;

import com.example.demo.bean.FactoryGood;
import com.example.demo.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {
    void insertGoods(Goods goods);

    List<Goods> findGoodAll();

    void deleteGoodByName(String username);

    Goods findGoodByName(String username);

    void  insertFactoryGoods(FactoryGood factoryGood);

    List<Goods>   findFactoryAllGood(String username);
    //删除goods表的商品通过id
    void   deleteGoodById(int id);
    //删除factorygoods表的商品与厂家的联系信息
    void   deleteFactoryGoods(int shangpingId);
}
