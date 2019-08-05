package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.util.List;

public class UserService {
    private  UserDao ud=new UserDao();
    public ResponseCode selectAll(String pageSize, String pageNum) {

        //逻辑
        if(pageSize==null || pageSize.equals("")){
            pageSize="10";
        }
        if(pageNum==null || pageNum.equals("")){
            pageNum="1";
        }

//        //调用数据层
//        UserDao ud=new UserDao();
        List<Users> li= ud.selectAll(pageSize,pageNum);

        //如果集合元素为空
        ResponseCode rs=ResponseCode.successRs(li);
        return  rs;
    }
    //查询，用户登录
    public ResponseCode selectOne(String username, String password) {
        ResponseCode  rs=new ResponseCode();

        //非空判断
        if(username==null ||username.equals("") ||password==null||password.equals("")){
           rs=ResponseCode.defateRs(1,"用户名或密码不存在");
           return  rs;
        }

        //查询是否有这样一个用户
        Users u = ud.selectOne(username,password);

        //如果用户不存在
        if(u==null){
            rs=ResponseCode.defateRs(1,"账户或密码错误");
            return  rs;
        }

        //用户权限
        if(u.getType()!=1){
            rs=ResponseCode.defateRs(2,"没有操作权限！");
            return  rs;
        }

        //登陆成功
         rs=ResponseCode.successRs(u);
            return rs;
    }

    //用户禁用
    public ResponseCode selectOne(String uids) {
        ResponseCode  rs=new ResponseCode();

        //非空判断
        if(uids==null ||uids.equals("") ){
            rs=ResponseCode.defateRs(Const.USER_PARAMETER_CODE,Const.USER_PARAMETER_MSG);
            return  rs;
        }

        //字符串转数值
        Integer uid=null;
        try{
           uid=Integer.parseInt(uids);
        }catch(Exception e){
            rs=ResponseCode.defateRs(Const.USER_NOEXIT_CODE,Const.USER_NOEXIT_MSG);
            return rs;
        }

     //查询是否有这样一个用户
        Users u = ud.selectOne(uid);

        //如果用户不存在
        if(u==null){
            rs=ResponseCode.defateRs(Const.USER_NO_CODE,Const.USER_NO_MSG);
            return  rs;
        }

        //用户禁用情况
        if(u.getStats()==1){
            rs=ResponseCode.defateRs(Const.USER_DISABLE_CODE,Const.USER_DISABLE_MSG);
            return  rs;
        }
        //禁用用户
        int row=ud.updateByUid(uid);
        if(row<=0){
            rs=ResponseCode.defateRs(Const.USER_DEFATED_CODE,Const.USER_DEFATED_MSG);
            return rs;
        }
        rs=ResponseCode.successRs(row);
        return rs;
    }
}
