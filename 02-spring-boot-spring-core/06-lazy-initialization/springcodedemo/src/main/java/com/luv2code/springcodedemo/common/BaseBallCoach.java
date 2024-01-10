package com.luv2code.springcodedemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class BaseBallCoach implements Coach{


    public BaseBallCoach(){
        System.out.println("Consrtuctor called" +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice ";
    }
}
