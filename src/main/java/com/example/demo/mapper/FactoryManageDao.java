package com.example.demo.mapper;

import com.example.demo.bean.DUser;
import com.example.demo.bean.FDG;
import com.example.demo.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FactoryManageDao {

    //通过厂商id查询 所有的fdg
    List<FDG> findFactoryDaili(int id);
    //通过商品id查询商品信息
    Goods findGoods(int id);
    //通过代理id查询代理信息
    DUser findDaili(int id);
    //通过fdg删除fdg
    void deleteFactorydaili(FDG fdg);


}
