package com.luv2code.springcodedemo.rest;

import com.luv2code.springcodedemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    // define private field for dependency
    private Coach myCoach;
    private Coach anotherCoach;

    // setter injection
    @Autowired
    public  DemoController(@Qualifier("cricketCoach") Coach theCoach,
                           @Qualifier("cricketCoach") Coach theAnotherCoach){

        System.out.println("Consrtuctor called" +getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;

    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


    @GetMapping("/check")
    public String check(){
        return "the comparing result is " +(anotherCoach == myCoach);
    }

}
