package com.ucaru.springiocdemo.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getWorkout() {
        return "Practice cricket smth";
    }
}
