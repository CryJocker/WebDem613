package com.werner.demo;

import com.werner.demo.bean.User;
import com.werner.demo.dao.impl.AccountDaoImpl;

/**
 * Created by zhangwei on 2017/6/14.
 */
public class Test {


    public static void main(String[] args) {
        AccountDaoImpl dao = new AccountDaoImpl();
        User user = dao.findUser("测试");
        System.out.println(user.toString());

    }
}
