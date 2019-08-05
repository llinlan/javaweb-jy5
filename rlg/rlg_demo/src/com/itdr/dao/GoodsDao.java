package com.itdr.dao;

import com.itdr.pojo.Goods;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
    //查找所有商品
    public List<Goods> selectAll() {
            //获取连接池
            QueryRunner qr=new QueryRunner(PoolUTil.getCom());
            String sql="select * from goods";
            List<Goods> li=null;
            try {
                //使用核心类
                li = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return  li;
        }
     //根据ID查找一个商品详情
     //根据ID查找一个用户
     public Goods selectOne(String gid) {
         //使用核心类
         QueryRunner qr=new QueryRunner(PoolUTil.getCom());
         String sql="select * from goods where id=?";
         Goods u= null;
         try {
             u = qr.query(sql, new BeanHandler<Goods>(Goods.class),gid);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return u;
     }
    }

