package com.myspring.core;

/**
 * ClassName:ApplicationContext
 * Package:com.myspring.core
 * Description:
 *
 */
public interface ApplicationContext {
    /**
     * 根据名字获取bean
     * @param name
     * @return
     */
    Object getBean(String name);
}
