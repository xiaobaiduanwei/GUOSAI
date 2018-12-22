package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Massage {

   private int states;
   private String detail;
   private Object user;
   public Massage(int states,String detail){
      this.detail=detail;
      this.states=states;
   }

}
