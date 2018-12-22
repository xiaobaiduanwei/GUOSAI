package com.example.demo.sever;

import com.example.demo.bean.FUser;
import com.example.demo.mapper.ApplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplyServer {
    @Autowired
    ApplyDao applyDao;
    //查询申请注册的厂家
    public List <FUser> lookApplyFactory(){

        return applyDao.findChangShangAll();
    }
    @Transactional
    public void appendFactory(String userName )throws Exception
    {
        FUser fUser = applyDao.findByFUserName(userName);
        applyDao.deleteChangShangByName(fUser.getUserName());
        applyDao.insertFactory(fUser);

    }
    //查询所有的厂家
    public List <FUser> lookFactory(){

        return applyDao.findFactoryAll();
    }

}
