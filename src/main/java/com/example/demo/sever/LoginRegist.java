package com.example.demo.sever;

import com.example.demo.bean.DUser;
import com.example.demo.bean.FUser;
import com.example.demo.bean.Massage;
import com.example.demo.bean.UserBase;
import com.example.demo.config.JwtTokenUtil;
import com.example.demo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginRegist {
    @Autowired
    UserDao userDao;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    public Massage RegistF(FUser u)throws  RuntimeException
    {

        if( StringUtils.isEmpty(userDao.findByFUserName(u.getUserName()))){
            if(userDao.insertFUser(u)){
                return new Massage(800,"注册成功");
            }
            else{
                return new Massage(200,"注册失败");
            }
        }

        else{
            return new Massage(300,"用户名存在");
        }
        }



    public Massage RegistD (DUser u)throws  RuntimeException
    {

        if( StringUtils.isEmpty(userDao.findByDUserName(u.getUserName()))){

            System.out.println(u.getUserName());
            if(userDao.insertDUser(u)){
                return new Massage(800,"注册成功");
            }
            else{
                return new Massage(200,"注册失败");
            }
        }

        else{
            return new Massage(300,"用户名存在");
        }
    }




    public String Login(String username, String password, String role)throws  RuntimeException{
        if(role.equals("admin")){
            UserBase userBase= userDao.findByAUserName(username);
           if( userBase.getPassword().equals(password)){
               return  jwtTokenUtil.create(userBase);
           }
          else{
              return "密码错误";
           }

        }
        else if(role.equals("factory")){
            UserBase userBase= userDao.findByFUserName(username);
            if( userBase.getPassword().equals(password)){
                return  jwtTokenUtil.create(userBase);
            }
            else{
                return "密码错误";
            }

        }
        else{
            UserBase userBase=  userDao.findByDUserName(username);
            if( userBase.getPassword().equals(password)){

                return  jwtTokenUtil.create(userBase);
            }
            else{
                return "密码错误";
            }
        }



    }




}
