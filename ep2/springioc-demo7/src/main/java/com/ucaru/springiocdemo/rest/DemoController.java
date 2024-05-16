package com.ucaru.springiocdemo.rest;


import com.ucaru.springiocdemo.common.Coach;
import com.ucaru.springiocdemo.common.CricketCoach;
import com.ucaru.springiocdemo.common.SwimCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private SwimCoach myCoach;

    @Autowired
    public DemoController(SwimCoach coach)
    {
        System.out.println("constructor: " + getClass().getSimpleName());
        myCoach = coach;
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


}
