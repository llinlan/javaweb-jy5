package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.GoodsDao;
import com.itdr.pojo.Goods;

import java.util.List;

public class GoodsService {
    private GoodsDao ud=new GoodsDao();
    public ResponseCode selectAll(String pageSize, String pageNum) {
        //逻辑
        if(pageSize==null || pageSize.equals("")){
            pageSize="10";
        }
        if(pageNum==null || pageNum.equals("")){
            pageNum="1";
        }
        List<Goods> li= ud.selectAll(pageSize,pageNum);

        //如果集合元素为空
        ResponseCode rs=new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return  rs;
    }

    }

