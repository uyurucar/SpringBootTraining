package com.ucaru.AspectAdviceDemo.service;


import com.ucaru.AspectAdviceDemo.Account;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{



    @Override
    public String getFortune() {


        //simulate delay
        try{
            TimeUnit.SECONDS.sleep(3);

        }catch (Exception e) {throw new RuntimeException(e);}
        //return string


        return "expect heavy traffic today";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire)
        {
            throw  new RuntimeException("EXC");
        }

        return getFortune();
    }
}
