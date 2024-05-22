package com.ucaru.AspectAdviceDemo.dao;


import com.ucaru.AspectAdviceDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{


    @Override
    public void addAccount(Account account, boolean vip) {

        System.out.println(getClass()  + ": hello");
    }
}
