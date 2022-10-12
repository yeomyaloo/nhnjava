package com.nhnacademy.edu.springframework.greeting;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class GreetingsService {

    private final List<Greeter> greeters;

    @Autowired
    public GreetingsService(List<Greeter> greeters) {
        this.greeters = greeters;
    }

    public void greet(){
        greeters.forEach(g->g.sayHello());
    }
}
