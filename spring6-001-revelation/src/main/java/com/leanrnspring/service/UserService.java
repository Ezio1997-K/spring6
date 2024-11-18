package com.leanrnspring.service;

import com.leanrnspring.dao.UserDao;

/**
 * ClassName:UserService
 * Package:com.leanrnspring.service
 * Description:
 *
 */
public class UserService {
    private UserDao userDao;
    public void saveUser(){
        userDao.insert();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
}
