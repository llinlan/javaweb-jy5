package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUTil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage/user/*")
public class Servlet_userController extends HttpServlet {

    private UserService uc=new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //怎么获取请求路径信息
        String pathInfo = request.getPathInfo();
        //调用工具类
        String path = PathUTil.getPath(pathInfo);

        ResponseCode rs = null;

        //判断一下是什么样的请求
        switch (path) {
            case "list":
              // rs = listDo(request);
                rs =listDo(request,response);
                break;
            case "login":
             // rs= loginDo(request);
                rs =loginDo(request,response);
                break;
            case "disableuser":
                rs= disableuserDo(request);
                break;

        }

//        //创建统一返回对象
//        ResponseCode rs = null;

        //调用业务层处理业务
        // UserService uc=new UserService();
        //  rs=uc.selectAll(pageSize,pageNum);

        /*
         *   List<Users> li =uc.selectAll(pageSize,pageNum);
         *遍历
         *   for (int i = 0; i <li.size() ; i++) {
         *   Users users=li.get(i);}
         * 写入前台客户端
         *   response.getWriter().write(users.toString()+"</br>");
         */

//        //返回响应数据
         // response.getWriter().write(rs.toString());
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));
    }
        //获取所有用户列表的请求
        private ResponseCode listDo(HttpServletRequest request,HttpServletResponse response){
           ResponseCode rs=new ResponseCode();
            //判断用户登陆状态
            HttpSession session = request.getSession();
            Users user=(Users)session.getAttribute("user");

            //获取参数
            String pageSize=request.getParameter("pageSize");
            String pageNum=request.getParameter("pageNum");

             rs = uc.selectAll(pageSize, pageNum);
            //放进域里面
//            request.setAttribute("uli",rs);


            //调用业务层处理业务
                return rs;

        }

        //用户登录请求
        private ResponseCode loginDo(HttpServletRequest request,HttpServletResponse response) {
            //获取参数
            String username=request.getParameter("username");
            String password=request.getParameter("password");

            ResponseCode rs = uc.selectOne(username, password);

            //获取session对象
            HttpSession session = request.getSession();
            session.setAttribute("user",rs.getData());
            //调用业务层处理业务
              return rs;
            //重定向
           // response.sendRedirect("home.jsp");
            //请求转发
//            try {
//                request.getRequestDispatcher("/homes.html").forward(request,response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        //禁用用户的请求
        private ResponseCode disableuserDo(HttpServletRequest request){
        //获取参数
        String uid=request.getParameter("uid");
        ResponseCode rs = uc.selectOne(uid);
        //调用业务层处理业务
        return  rs;
    }
    //根据用户ID修改用户信息
}





