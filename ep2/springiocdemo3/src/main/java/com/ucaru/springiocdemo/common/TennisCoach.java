package com.ucaru.springiocdemo.common;


import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getWorkout() {
        return "i am tennis coach";
    }
}
