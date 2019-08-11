package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.CategoryDao;
import com.itdr.pojo.Categorys;

import java.util.ArrayList;
import java.util.List;


public class CategoryService {
    private CategoryDao cd=new CategoryDao();
    public ResponseCode get_deep_categoryDo(String pid) {
        //非空判断

        Integer pidi =Integer.parseInt(pid);

        List<Integer> li=new ArrayList<>();
        getAll(pidi,li);

       ResponseCode rs=ResponseCode.successRs(li);
        return rs;
    }

    private void getAll(Integer pidi,List<Integer> list){
        List<Categorys> li=cd.getAll(pidi);
        if (li!=null&&li.size()!=0){
            for (Categorys categorys: li) {
                list.add(categorys.getId());
                getAll(categorys.getId(),list);
            }
        }
    }
}
