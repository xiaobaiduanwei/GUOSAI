package com.example.demo.mapper;

import com.example.demo.bean.FUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyDao {
    FUser findByFUserName(String username);

    boolean  insertFactory(FUser fUser);

    boolean  deleteChangShangByName(String username);

    List<FUser> findChangShangAll();

    FUser findFactoryUserName(String username);
    //查询所有的厂商
    List<FUser> findFactoryAll();
}
