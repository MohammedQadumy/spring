package com.luv2code.springcodedemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// by default the scope is false , prototype create an instance for each bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {


    public CricketCoach(){
        System.out.println("Consrtuctor called" +getClass().getSimpleName());
    }


    //define our init method
    // define our destroy method

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In do my startUp stuff "+ getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("Destroyyyyyyyyyyyyy  "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!";
    }
}
