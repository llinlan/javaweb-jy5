package com.itdr.dao;

import com.itdr.pojo.Goods;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {

    //获取连接池
    QueryRunner qr=new QueryRunner(PoolUTil.getCom());

    //查找所有商品
    public List<Goods> selectAll() {

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

     //根据ID和NAME查找一个商品
    public Goods selectOne(String gid,String gname) {
        //使用核心类
        QueryRunner qr=new QueryRunner(PoolUTil.getCom());
        String sql="select * from goods where id=?and gname=?";
         Goods li= null;
         try {
          li = qr.query(sql, new BeanHandler<Goods>(Goods.class),gid,gname);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return li;
     }

    //根据ID查看商品详情
    public Goods selectOneAll(String gid) {
            QueryRunner qr=new QueryRunner(PoolUTil.getCom());
            String sql = "select * from goods where id = ?";
            Goods li = null;
            try {
                li = qr.query(sql,new BeanHandler<Goods>(Goods.class),gid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return li;
        }

    //上下架
    public Integer updateOne(String status,String gid) {
            String sql = "update product set status = ? where id = ?";
            int a = 0;
            try {
                a = qr.update(sql,status,gid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return a;

        }


    public List<Goods> fingByText(String keyWord) {
        String sql="select * from goods where pname like?";
        String key="%"+keyWord+"%";
        List<Goods> li=null;
        try {
            //使用核心类
            li = qr.query(sql, new BeanListHandler<Goods>(Goods.class),key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  li;
    }
}


