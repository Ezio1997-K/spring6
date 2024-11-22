package com.example.bean;

import com.learnspring.client.MyComponent;

/**
 * ClassName:User
 * Package:com.example.bean
 * Description:
 *
 */
@MyComponent("userBean")
public class User {
    public void study(){
        System.out.println("学生学习...");
    }
}
