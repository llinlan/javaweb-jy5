package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.OrdersDao;
import com.itdr.pojo.Goods;
import com.itdr.pojo.Orders;

import java.util.List;

public class OrderService {
    private OrdersDao gd = new OrdersDao();

    //订单列表
    public ResponseCode selectAll(String pageSize, String pageNum) {
        ResponseCode rs=null;
        List<Orders> li=gd.selectAll();
        rs=ResponseCode.successRs(li);
        return rs;
    }

    // 根据ID查看商品详情
    public ResponseCode selectOneAll(String orderNo) {
        ResponseCode rs = new ResponseCode();
        Orders li  = gd.selectOneAll(orderNo);
        if(li==null){
            rs=ResponseCode.defateRs(Const.ORDERS_NULL_CODE,Const.ORDERS_NULL_MSG);
            return  rs;
        }
        rs = ResponseCode.successRs(li);
        return rs;

    }
}
