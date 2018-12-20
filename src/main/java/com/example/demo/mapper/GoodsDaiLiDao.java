package com.example.demo.mapper;

import com.example.demo.bean.DUser;
import com.example.demo.bean.FDG;
import com.example.demo.bean.FUser;
import com.example.demo.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDaiLiDao {
    //查询代理通过名字
    DUser findDaiLiByName(String username);

   void   insertFactoryDailiApply(FDG fdg);

    void   insertFactoryDaili(FDG fdg);

    void   deleteFactoryDaili(FDG fdg);

    void   deleteFactoryDailiApply(FDG fdg);

    DUser findDaiLiById(int id);

    FUser findFactoryById(int id);

    Goods findGoodsById(int id);
    //将商品代理申请拒绝的消息删除
    void   insertNote(FDG fdg);
    //通过厂商的id查询它的提示信息
    List<FDG>   findNoteByDailiId(int id);
    //通过厂商id查看代理申请信息
    List<FDG>  findDailiApplyById(int id);

}
