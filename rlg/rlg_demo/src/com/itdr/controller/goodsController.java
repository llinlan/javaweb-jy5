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

@WebServlet(name = "goodsController",value = "/manage/product/list.do")
public class goodsController extends HttpServlet {

    private GoodsService uc=new GoodsService();

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
                rs = listDo(request);
                break;
        }
        //返回响应数据
        response.getWriter().write(rs.toString());
    }
        //获取商品列表的请求
        private ResponseCode listDo(HttpServletRequest request){
            ResponseCode rs=new ResponseCode();
            //判断用户登陆状态
            HttpSession session = request.getSession();
            Users user=(Users)session.getAttribute("user");
            if(user==null){
                rs.setData(3);
                rs.setMag("请登陆后操作！");
                return rs;
            }
            if(user.getType()!=1){
                rs.setData(3);
                rs.setMag("没有操作权限！");
                return rs;
            }
            //获取参数
            String pageSize=request.getParameter("pageSize");
            String pageNum=request.getParameter("pageNum");
            rs = uc.selectAll(pageSize, pageNum);
            //调用业务层处理业务
            return rs;

        }
    }

