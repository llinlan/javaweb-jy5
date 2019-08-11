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

    //请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求路径信息
        String pathInfo = request.getPathInfo();

        //调用工具类
        String path = PathUTil.getPath(pathInfo);
        ResponseCode rs = null;

        //判断一下是什么样的请求
        switch (path) {
            case "list":
//            rs = getAll(request);
                rs=listDo(request);
                break;
            case "sousuo":
               rs= sousuoDo(request);
                break;
            case "detail":
                rs = detailDo(request);
                break;
            case "set_sale_status":
                rs = set_sale_statusDo(request);
                break;
            case "search":
                rs = findByText(request);
                break;
        }
        //返回响应数据
        response.getWriter().write(rs.toString());
    }
//        private void getAll(HttpServletRequest request,HttpServletResponse response){
//            //调用业务层处理业务
//            ResponseCode  rs= gs.getAll();
//            return rs;
//            request.setAttribute("gli",rs);
//
//            try {
//                //请求转发，
//                request.getRequestDispatcher("/WEB-INF/goodslist.jsp").forward(request,response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//        }

    //获取商品列表
    private ResponseCode listDo(HttpServletRequest request) {
    //获取参数
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        ResponseCode rs = gs.selectAll(pageSize,pageNum);
     //调用业务层处理业务
             return rs;
}

    //搜索商品列表
    private ResponseCode sousuoDo(HttpServletRequest request){
        //获取参数
        String gid=request.getParameter("gid");
        String gname=request.getParameter("gname");
        ResponseCode rs = gs.selectOne(gid,gname);
        //调用业务层处理业务
        return  rs;
    }

    //商品详情
    private ResponseCode detailDo(HttpServletRequest request) {
        String gid = request.getParameter("gid");
        ResponseCode rs =  gs.selectOneAll(gid);
        return rs ;

    }

    //商品上下架
    private ResponseCode set_sale_statusDo(HttpServletRequest request) {
        String gid = request.getParameter("gid");
        String status = request.getParameter("status");
        ResponseCode rs =  gs.updateOne(gid,status);
        return rs ;
    }

    //新增OR更新产品
    //图片上传
    public void upImg(HttpServletRequest request){

    }
    //富文本上传

    //根据内容模糊查询
    private ResponseCode findByText(HttpServletRequest request){
        //获取参数
        String keyWord=request.getParameter("key");
        ResponseCode rs=gs.fingByText(keyWord);
        return  rs;
    }
}