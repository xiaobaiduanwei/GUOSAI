package com.example.demo.sever;

import com.example.demo.bean.FUser;
import com.example.demo.bean.FactoryGood;
import com.example.demo.bean.Goods;
import com.example.demo.mapper.ApplyDao;
import com.example.demo.mapper.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodServer {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    ApplyDao applyDao;

    @Transactional
    public void goodAppend(Goods goods, String username) throws  Exception{//商品添加 参数：商品 和厂商的名字

       goodsDao.insertGoods(goods);
       Goods good = goodsDao.findGoodByName(goods.getShangpingName());
        FactoryGood factoryGood = new FactoryGood();
        FUser fUser = applyDao.findFactoryUserName(username);
        factoryGood.setChangshangid(fUser.getId());
        factoryGood.setShangpingId(good.getId());
        goodsDao.insertFactoryGoods(factoryGood);
    }
    //通过厂商的名字查询他的所有商品
    public List<Goods> findGoodsByFactory(String username) throws  Exception {

        return goodsDao.findFactoryAllGood(username);

    }

    //删除商品
    @Transactional
    public  void  deleteGoods(int id){
        goodsDao.deleteGoodById(id);
        goodsDao.deleteFactoryGoods(id);

    }


}
