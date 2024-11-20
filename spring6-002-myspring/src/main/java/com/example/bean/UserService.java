package com.example.bean;

/**
 * ClassName:UserService
 * Package:com.example.bean
 * Description:
 *
 */
public class UserService {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void init(){
        System.out.println("UserService init...");
        userDAO.destroy();
    }
}
