package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodSell {
    //代理商在商品代售时所添加的商品的售价，和商品的描述
    private int factorydailliId;
    private float sellPrice;
    private String miaoshuD;


}
