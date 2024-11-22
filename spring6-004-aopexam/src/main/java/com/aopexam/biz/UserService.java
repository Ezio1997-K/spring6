package com.aopexam.biz;

import org.springframework.stereotype.Service;

/**
 * ClassName:UserService
 * Package:com.aopexam.biz
 * Description:
 *
 */
@Service
public class UserService {
    public void getUser(){
        System.out.println("获取用户信息");
    }
    public void saveUser(){
        System.out.println("保存用户");
    }
    public void deleteUser(){
        System.out.println("删除用户");
    }
    public void modifyUser(){
        System.out.println("修改用户");
    }
}
