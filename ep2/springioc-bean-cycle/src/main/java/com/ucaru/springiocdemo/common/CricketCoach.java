package com.ucaru.springiocdemo.common;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
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

    //init method
    @PostConstruct
    public void doStartup()
    {
        System.out.println("this is init method " + getClass().getSimpleName());
    }
    //destroy method

    @PreDestroy
    public void doDestroy()
    {
        System.out.println("this is method before destroy " + getClass().getSimpleName());
    }
}
