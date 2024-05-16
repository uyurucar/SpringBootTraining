package com.ucaru.springiocdemo.common;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach{
    @Override
    public String getWorkout() {
        return "i am track coach";
    }
}
