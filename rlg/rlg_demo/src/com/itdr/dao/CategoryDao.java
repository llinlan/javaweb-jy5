package com.itdr.dao;

import com.itdr.pojo.Categorys;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUTil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    //查找所有用户
    public List<Categorys> getAll(Integer pidi) {
        //使用核心类
        QueryRunner qr=new QueryRunner(PoolUTil.getCom());
        String sql="select * from Categorys where pid=?";
        List<Categorys> li=null;
        try {
            li = qr.query(sql, new BeanListHandler<Categorys>(Categorys.class),pidi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    }

