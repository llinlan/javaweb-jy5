package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.utils.PathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderController" ,value = "/manage/order/*")
public class OrdersController extends HttpServlet {

    private OrderService gs= new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //需求
        //获取请求路径信息
        String pathInfo = request.getPathInfo();

        //调用工具类
        String path = PathUTil.getPath(pathInfo);
        ResponseCode rs = null;

        //判断一下是什么样的请求
        switch (path) {
            case "list":
                rs=listDo(request);
                break;
            case "detail":
                rs=detailDo(request);
                break;
        }
        //返回响应数据
        response.getWriter().write(rs.toString());
    }

    //订单列表，订单详情
    private ResponseCode listDo(HttpServletRequest request) {
            //获取参数
            String pageSize = request.getParameter("pageSize");
            String pageNum = request.getParameter("pageNum");
            ResponseCode rs = gs.selectAll(pageSize,pageNum);
            //调用业务层处理业务
            return rs;
        }

     //按订单号查询
     private ResponseCode detailDo(HttpServletRequest request) {
            String orderNo = request.getParameter("orderNo");
            ResponseCode rs =  gs.selectOneAll(orderNo);
            return rs ;

        }

     //订单发货
}

