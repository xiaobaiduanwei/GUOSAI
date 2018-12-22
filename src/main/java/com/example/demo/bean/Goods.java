package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goods {

    private int id     ;
    private String shangpingName ;
    private String shangpingPhotoUrl;
    private  float shangpingPrice;
    private String miaoShu ;
    private String Label   ;
    private String sizea    ;
    private String producingArea;


}
