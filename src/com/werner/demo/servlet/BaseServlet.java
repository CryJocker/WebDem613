package com.werner.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得服务器请求的方法名
        String name = req.getParameter("method");
        //获取当前Servlet的Class对象
        Class<? extends BaseServlet> cls = this.getClass();
        Method method = null;
        try {
            //通过请求的方法来获取servlet对应的方法
            method = cls.getDeclaredMethod(name, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (method != null) {
            try {
                //如果调用私有方法必须设置为true
                method.setAccessible(true);
//                调用Servlet的相应的方法
                method.invoke(this, req, resp);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
