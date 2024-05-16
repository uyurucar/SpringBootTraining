package com.ucaru.springiocdemo.rest;


import com.ucaru.springiocdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
/*
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach coach)
    {
        myCoach = coach;
    }
*/
    @Autowired
    public DemoController( Coach coach)
    {
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return "<h1>" + myCoach.getWorkout()+ "</h1>";
    }

}
