package com.learnspring6.bank.service.impl;

import com.learnspring6.bank.DAO.AccountDao;
import com.learnspring6.bank.service.AccountService;
import com.learnspring6.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * ClassName:AccountServiceImpl
 * Package:com.learnspring6.bank.service.impl
 * Description:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromAcco, String toAcco, double money) {
        Account fAcco = accountDao.selectByActno(fromAcco);
        Account tAcco = accountDao.selectByActno(toAcco);
        if (fAcco.getBalance() < money)
            throw new RuntimeException("余额不足！");
        fAcco.setBalance(fAcco.getBalance() - money);
        tAcco.setBalance(tAcco.getBalance() + money);
        int count = accountDao.update(fAcco);
        count+=accountDao.update(tAcco);
        if(count!=2)
            throw new RuntimeException("转账失败");
    }
}
