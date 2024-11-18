package com.leanrnspring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:UserDao
 * Package:com.leanrnspring.dao
 * Description:
 *
 */
public class UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    public void insert(){
        LOGGER.info("数据库正在保存用户信息");
    }
}
