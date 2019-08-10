package com.itdr.dao;

import com.itdr.pojo.Orders;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrdersDao {
    //获取连接池
    QueryRunner qr=new QueryRunner(PoolUTil.getCom());

    //查找所有订单
    public List<Orders> selectAll() {
            String sql="select * from orders";
            List<Orders> li=null;
            try {
                //使用核心类
                li = qr.query(sql, new BeanListHandler<Orders>(Orders.class));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return  li;
        }

    //根据ID查看订单详情
    public Orders selectOneAll(String orderNo) {
        QueryRunner qr=new QueryRunner(PoolUTil.getCom());
        String sql = "select * from orders where orderNo = ?";
        Orders li = null;
        try {
            li = qr.query(sql,new BeanHandler<Orders>(Orders.class),orderNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
    }

