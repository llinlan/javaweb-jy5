package com.itdr.dao;

import com.itdr.pojo.Goods;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
    //查找所有用户
    public List<Goods> selectAll(String pageSize, String pageNum) {
            //获取连接池
            //使用核心类
            QueryRunner qr=new QueryRunner(PoolUTil.getCom());
            String sql="select * from goods";
            List<Goods> li=null;
            try {
                li = qr.query(sql, new BeanListHandler<>(Goods.class));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return  li;
        }
    }

