package com.werner.demo.service.imp;

import com.werner.demo.bean.User;
import com.werner.demo.dao.AccountDao;
import com.werner.demo.dao.impl.AccountDaoImpl;
import com.werner.demo.service.IAccountService;

/**
 *
 */
public class AccountService implements IAccountService {
    private AccountDao dao;

    public AccountService() {
        dao = new AccountDaoImpl();
    }

    @Override
    public User login(String username, String password) {
        User user = dao.findUser(username);
        if (user != null && !"".equals(user.getTpassword()) && password.equals(user.getTpassword())) {
            return user;
        }
        return null;
    }

    @Override
    public int register(String username, String password) {
        int addnum = dao.addUser(username,password);


        return addnum;
    }


}
