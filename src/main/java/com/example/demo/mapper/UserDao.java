package com.example.demo.mapper;

import com.example.demo.bean.DUser;
import com.example.demo.bean.FUser;
import com.example.demo.bean.UserBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    UserBase findByDUserName(String username);

    UserBase findByAUserName(String username);

    UserBase findByFUserName(String username);

    boolean  insertFUser(FUser fUser);

    boolean  insertDUser(DUser dUser);



}




