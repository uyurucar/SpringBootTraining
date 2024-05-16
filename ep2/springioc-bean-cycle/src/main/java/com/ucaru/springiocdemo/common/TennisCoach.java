package com.ucaru.springiocdemo.common;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach()
    {
        System.out.println("constructor:" + getClass().getSimpleName());
    }
    @Override
    public String getWorkout() {
        return "i am tennis coach";
    }

    //init method
    @PostConstruct
    public void doStartup()
    {
        System.out.println("this is init method " + getClass().getSimpleName());
    }
    //destroy method
}
