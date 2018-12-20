package com.example.demo.controller;

import com.example.demo.bean.DUser;
import com.example.demo.bean.FUser;
import com.example.demo.bean.Massage;
import com.example.demo.bean.UserBase;
import com.example.demo.config.JwtTokenUtil;
import com.example.demo.sever.LoginRegist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class LoginAndRegist {

    @Autowired
    LoginRegist loginRegist;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Massage login(@RequestBody UserBase userBase) {
      //  System.out.println(userBase.getUserName());
        String token =loginRegist.Login(userBase.getUserName(),userBase.getPassword(), userBase.getRole());
        //System.out.println(token);

       if( token.equals("密码错误")){

           return new Massage(200,"登录失败");
       }

        return new Massage(2400,token+"", jwtTokenUtil.parse(token));
    }

    @GetMapping("/registf/{username}")
    @ResponseBody
    public Massage registf(@PathVariable("username") FUser u) throws  RuntimeException{



        return loginRegist.RegistF(u);

    }

    @GetMapping("/registd/{username}")
    @ResponseBody
    public Massage registd (@PathVariable("username") DUser u) throws  RuntimeException{


        return loginRegist.RegistD(u);
    }
}