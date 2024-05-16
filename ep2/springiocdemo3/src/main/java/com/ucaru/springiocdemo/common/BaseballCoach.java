package com.ucaru.springiocdemo.common;


import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getWorkout() {
        return "i am baseball coach";
    }
}
