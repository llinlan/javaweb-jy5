package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.CategoryService;
import com.itdr.service.GoodsService;
import com.itdr.utils.PathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "goodsController",value = "/manage/category/*")
public class CategoryController extends HttpServlet {

    private CategoryService cs= new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    //请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求路径信息
        String pathInfo = request.getPathInfo();

        //调用工具类
        String path = PathUTil.getPath(pathInfo);
        ResponseCode rs = null;

        //判断一下是什么样的请求
        switch (path) {
            case "get_deep_category":
                rs=get_deep_categoryDo(request);
                break;
        }
        //返回响应数据
        response.getWriter().write(rs.toString());
    }
    //根据分类ID查询所有的子类
    private ResponseCode get_deep_categoryDo(HttpServletRequest request) {
    //获取参数
        String pid = request.getParameter("pid");
        ResponseCode rs = cs.get_deep_categoryDo(pid);
     //调用业务层处理业务
             return rs;
}


}