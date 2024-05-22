package com.ucaru.AspectAdviceDemo.dao;

import com.ucaru.AspectAdviceDemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vip);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    public String getName1();

    public void setName1(String name1);

    public String getName2();

    public void setName2(String name2);

}
