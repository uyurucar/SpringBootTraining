package com.ucaru.springiocdemo.common;


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
}
