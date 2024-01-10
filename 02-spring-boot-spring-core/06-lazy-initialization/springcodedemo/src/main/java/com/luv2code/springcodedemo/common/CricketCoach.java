package com.luv2code.springcodedemo.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {


    public CricketCoach(){
        System.out.println("Consrtuctor called" +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!";
    }
}
