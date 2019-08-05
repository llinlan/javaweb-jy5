package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.GoodsDao;
import com.itdr.pojo.Goods;

import java.util.List;

public class GoodsService {
    private GoodsDao gd = new GoodsDao();
    public ResponseCode getAll() {
        ResponseCode rs=null;
        List<Goods> li=gd.selectAll();
        rs=ResponseCode.successRs(li);
        return rs;
    }

    public ResponseCode selectOne(String gid) {
        ResponseCode  rs=new ResponseCode();
        //查询是否有这样一个商品
        Goods u = gd.selectOne(gid);
        //如果商品不存在
        if(u==null){
            rs=ResponseCode.defateRs(Const.GOODS_NULL_CODE,Const.GOODS_NULL_MSG);
            return  rs;
        }
        rs=ResponseCode.successRs(u);
        return rs;
    }

}
