package com.ucaru.springiocdemo.common;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach()
    {
        System.out.println("constructor:" + getClass().getSimpleName());
    }

    @Override
    public String getWorkout() {
        return "Practice cricket smth xd";
    }

}
