package com.learnspring6.bank.DAO;

import com.learnspring6.bank.pojo.Account;

/**
 * ClassName:AccountDao
 * Package:com.learnspring6.bank.DAO
 * Description:
 *
 */
public interface AccountDao {
    /**
     * 根据账号查询余额
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户
     * @param act
     * @return
     */
    int update(Account act);
}
