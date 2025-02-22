package com.learnspring.bank.pojo;

/**
 * ClassName:Account
 * Package:com.learnspring.bank.pojo
 * Description:
 *
 */
public class Account {
    private String actno;
    private Double balance;

    public Account() {
    }

    public Account(String actno, Double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    /**
     * 获取
     * @return actno
     */
    public String getActno() {
        return actno;
    }

    /**
     * 设置
     * @param actno
     */
    public void setActno(String actno) {
        this.actno = actno;
    }

    /**
     * 获取
     * @return balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * 设置
     * @param balance
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Account{actno = " + actno + ", balance = " + balance + "}";
    }
}
