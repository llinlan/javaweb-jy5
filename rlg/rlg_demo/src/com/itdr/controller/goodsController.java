package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.GoodsService;
import com.itdr.utils.PathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "goodsController",value = "/manage/product/*")
public class goodsController extends HttpServlet {
    private GoodsService gs= new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求路径信息
        String pathInfo = request.getPathInfo();

        //调用工具类
        String path = PathUTil.getPath(pathInfo);
        ResponseCode rs = null;

        //判断一下是什么样的请求
        switch (path) {
            case "list":
                rs = getAll(request);
                break;
        }
        //返回响应数据
        response.getWriter().write(rs.toString());
    }
        //获取商品列表
        private ResponseCode getAll(HttpServletRequest request){
            ResponseCode rs=new ResponseCode();
            //调用业务层处理业务
            rs= gs.getAll();
            return rs;

        }

        private ResponseCode sousuoDo(HttpServletRequest request){
        //获取参数
        String gid=request.getParameter("gid");
        ResponseCode rs = gs.selectOne(gid);
        //调用业务层处理业务
        return  rs;
    }
    }

