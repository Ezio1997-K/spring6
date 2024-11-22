package com.learnspring.client.proxy.util;


import com.example.bean.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;


import java.lang.reflect.Method;

/**
 * ClassName:TestCGLIB
 * Package:com.learnspring.client.proxy.util
 * Description:
 *
 */
public class TestCGLIB {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(User.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.print("学生应该先找个好的环境再");
            return methodProxy.invokeSuper(o,null);
        });
        User userProxy = (User) enhancer.create();
        userProxy.study();
    }
}
