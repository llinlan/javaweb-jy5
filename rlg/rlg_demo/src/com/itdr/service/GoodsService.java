package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.GoodsDao;
import com.itdr.pojo.Goods;

import java.util.List;

public class GoodsService {
    private GoodsDao gd = new GoodsDao();

    //获取商品列表
    public ResponseCode selectAll(String pageSize, String pageNum) {
        ResponseCode rs=null;
        List<Goods> li=gd.selectAll();
        rs=ResponseCode.successRs(li);
        return rs;
    }

    //根据ID和name查看商品详情
    public ResponseCode selectOne(String gid,String gname) {
        ResponseCode  rs=new ResponseCode();
        //查询是否有这样一个商品
        Goods u = gd.selectOne(gid,gname);
        //如果商品不存在
        if(u==null){
            rs=ResponseCode.defateRs(Const.GOODS_NULL_CODE,Const.GOODS_NULL_MSG);
            return  rs;
        }
        rs=ResponseCode.successRs(u);
        return rs;
    }

    // 根据ID查看商品详情
    public ResponseCode selectOneAll(String gid) {
        ResponseCode rs = new ResponseCode();
        Goods li  = gd.selectOneAll(gid);
        if(li==null){
            rs=ResponseCode.defateRs(Const.GOODS_NULL_CODE,Const.GOODS_NULL_MSG);
            return  rs;
        }
        rs = ResponseCode.successRs(li);
        return rs;

}

    //商品上下架
    public ResponseCode updateOne( String status,String gid) {
//            ResponseCode rs = new ResponseCode();
            Integer id = Integer.parseInt(gid);
             Integer st = Integer.parseInt(status);
             ResponseCode li=updateOne(status,gid);
            if(id!=0){
                li =ResponseCode.defateRs(Const.GOODS_UPDATED_CODE,Const.GOODS_UPDATED_MSG);
                return li;
            }
            li =ResponseCode.successRs(Const.GOODS_UPDATE_CODE,Const.GOODS_UPDATE_MSG);
            return li;
        }

    public ResponseCode fingByText(String keyWord) {
        //非空判断
        ResponseCode rs=null;
        List<Goods> li=gd.fingByText(keyWord);
        rs=ResponseCode.successRs(li);
        return rs;
    }
}

