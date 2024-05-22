package com.ucaru.AspectAdviceDemo.dao;


import com.ucaru.AspectAdviceDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name1;
    private String name2;

    @Override
    public void addAccount(Account account, boolean vip) {

        System.out.println(getClass()  + ": hello");
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        //simulate an exception
        if(tripWire)
        {
            throw new RuntimeException("FAKE EXCEPTION");
        }

        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("one","low"));
        accounts.add(new Account("two","med"));
        accounts.add(new Account("three","high"));

        return accounts;
    }

    public String getName1() {
        System.out.println(getClass()  + ": get");
        return name1;
    }

    public void setName1(String name1) {

        System.out.println(getClass()  + ": set");

        this.name1 = name1;
    }

    public String getName2() {

        System.out.println(getClass()  + ": get");

        return name2;
    }

    public void setName2(String name2) {

        System.out.println(getClass()  + ": set");

        this.name2 = name2;
    }
}
