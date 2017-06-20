package com.werner.demo.service;

import com.werner.demo.bean.User;

/**
 * Created by zhangwei on 2017/6/14.
 */
public interface IAccountService {
    User login(String username, String password);
    int register(String username, String password);
}
