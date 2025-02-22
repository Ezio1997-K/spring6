package com.learnspring.bank.mapper;

import com.learnspring.bank.pojo.Account;

import java.util.List;

/**
 * ClassName:AccountMapper
 * Package:com.learnspring.bank.mapper
 * Description:
 *
 */
public interface AccountMapper {
    int insert(Account account);
    int deleteByActno(String actno);
    int update(Account account);
    Account selectByActno(String actno);
    List<Account> selectAll();
}
