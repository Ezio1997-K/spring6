package com.learnspring.client.proxy.util;

/**
 * ClassName:ProxyUtil
 * Package:com.learnspring.client.proxy.util
 * Description:
 *
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
@SuppressWarnings("all")
public class ProxyUtil {
    /**
     * 执行动态代理
     * @param t 代理对象
     * @param invocationHandler 调用处理程序
     * @param <T> 返回值
     * @return 该代理对象
     */
    public static <T> T proxyObject(T t, InvocationHandler invocationHandler) {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                invocationHandler);
    }

}