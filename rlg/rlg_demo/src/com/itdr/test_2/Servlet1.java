package com.itdr.test_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet1" ,value="/manage/user/s1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getRequestURI());    //    /manage/user/login.do
        System.out.println(request.getRequestURL());// http://localhost:8080/manage/user/login.do
        System.out.println(request.getServletPath()); //        /manage/user
        System.out.println(request.getRequestedSessionId()); //        null
        System.out.println(request.getRemoteUser()); //        null
        System.out.println(request.getQueryString()); //        null
        System.out.println(request.getPathTranslated());//        E:\soft\ideacode\rlg\out\artifacts\rlg_demo_war_exploded\login.do
        System.out.println(request.getPathInfo());//        /login.do
        System.out.println(request.getAuthType()); //        null
        System.out.println(request.getMethod());  //        GET
        System.out.println(request.getContextPath()); //什么也没有

    }
}
