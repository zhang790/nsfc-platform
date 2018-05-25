package com.nsfc.practice.rhread.all.two;

/**
 * 账户模拟类
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/14
 */
public class Account {

    private String accountId;

    private double money;

    public Account(String accountId, double money) {
        this.accountId = accountId;
        this.money = money;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
