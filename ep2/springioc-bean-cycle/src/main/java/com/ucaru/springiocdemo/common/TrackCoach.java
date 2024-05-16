package com.ucaru.springiocdemo.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TrackCoach implements Coach{

    public TrackCoach()
    {
        System.out.println("constructor:" + getClass().getSimpleName());
    }
    @Override
    public String getWorkout() {
        return "i am track coach";
    }
}
