package com.leanrn.test;

import com.leanrnspring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:TestModule
 * Package:com.leanrn.test
 * Description:
 *
 */
public class TestModule {
    @Test
    public void testSetInjection(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.saveUser();
    }
}
