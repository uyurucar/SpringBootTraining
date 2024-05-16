package com.ucaru.springiocdemo.common;

public class SwimCoach implements Coach{

    public SwimCoach()
    {
        System.out.println("constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getWorkout() {
        return "i am swim coach";
    }
}
