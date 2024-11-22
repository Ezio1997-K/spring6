package com.aopexam.service;

import org.springframework.stereotype.Service;

/**
 * ClassName:OrderService
 * Package:com.aopexam.service
 * Description:
 *
 */
@Service
public class OrderService {
    // 生成订单
    public void generate(){
        System.out.println("正在生成订单");
    }
    // 取消订单
    public void cancel(){
        System.out.println("正在取消订单");
        if(1==1)
            throw new RuntimeException("故意抛出异常");
    }
}
