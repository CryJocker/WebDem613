package com.werner.demo.dao;

import com.werner.demo.bean.User;

/**
 * Created by zhangwei on 2017/6/14.
 */
public interface AccountDao {

    User findUser(String name);
    int addUser(String name,String password);


}
