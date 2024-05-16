package com.ucaru.springiocdemo.rest;


import com.ucaru.springiocdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach anthCoach)
    {
        System.out.println("constructor: " + getClass().getSimpleName());
        myCoach = coach;
        anotherCoach = anthCoach;
    }
    /*
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach)
    {
        System.out.println("constructor:" + getClass().getSimpleName());
        myCoach = coach;
    }
    */
 /*
    @Autowired
    public DemoController( Coach coach)
    {
        myCoach = coach;
    }
 */

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return "<h1>" + myCoach.getWorkout()+ "</h1>";
    }

    @GetMapping("/check")
    public String check()
    {
        return "comparing beans: " + (myCoach == anotherCoach);
    }

}
