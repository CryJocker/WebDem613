package com.werner.demo.servlet;

import com.werner.demo.bean.User;
import com.werner.demo.service.IAccountService;
import com.werner.demo.service.imp.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

/**
 * 反射简单实用
 * 关于一个Servlet处理多个请求
 */

public class AccountServlet extends BaseServlet {


    IAccountService service;

    @Override
    public void init() throws ServletException {
        service = new AccountService();
    }



    public void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            User user = service.login(username, password);
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String key = parameterNames.nextElement();
            }
            if (user != null) {
                response.sendRedirect("/index.jsp");
            } else {
                response.sendRedirect("/error.html");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void register(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            int n = service.register(username,password);
            if(n == 1){
                response.sendRedirect("/login.html");
            }
            else{
                response.sendRedirect("/error.html");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
