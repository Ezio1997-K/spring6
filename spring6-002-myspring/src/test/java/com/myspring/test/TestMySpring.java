package com.myspring.test;

import com.example.bean.UserService;
import com.myspring.core.ApplicationContext;
import com.myspring.core.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * ClassName:TestMySpring
 * Package:com.myspring.test
 * Description:
 *
 */
public class TestMySpring {
    @Test
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("myspring.xml");
        Object user = app.getBean("user");
        System.out.println(user);
        UserService userService = (UserService) app.getBean("userService");
        System.out.println(userService);
        userService.init();
    }
    @Test
    public void test2(){
        Integer a = 1;
        Integer b = 2;
        System.out.println(a.getClass() == b.getClass());
        System.out.println(a.getClass() == int.class);
    }
}
