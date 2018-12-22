package com.example.demo.config;

import com.example.demo.bean.UserBase;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtTokenUtil {
    /**
     * token过期时间
     */
    @Value("${jwt.validity-time}")
    private long validityTime; // 24 hours  validity
    /**
     * header中标识
     */
    @Value("${jwt.header}")
    private String header;
    /**
     * 加密密钥
     */
    @Value("${jwt.secret}")
    private String secret;


    /**
     * 验签
     * 从用户中创建一个jwt Token
     * @param userDTO 用户
     * @return token
     */
    public String create(UserBase userBase ) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + validityTime))
                .setIssuedAt(new Date(System.currentTimeMillis() + validityTime/3*2 ))
                .claim("username",userBase.getUserName())
                .claim("password",userBase.getPassword())
                .claim("roles",userBase.getRole())
                .claim("id",userBase.getId())
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    /**
     * 从token中取出用户
     */
    public UserBase parse(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        UserBase userDTO = new UserBase();
        userDTO.setPassword(claims.get("password",String.class));
        userDTO.setUserName(claims.get("username",String.class));
        userDTO.setRole( claims.get("roles",String.class));
        userDTO.setId( claims.get("id",Integer.class));
        return userDTO;
    }
}
