package com.ucaru.springiocdemo.common;


import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach()
    {
        System.out.println("constructor:" + getClass().getSimpleName());
    }
    @Override
    public String getWorkout() {
        return "i am baseball coach";
    }
}
