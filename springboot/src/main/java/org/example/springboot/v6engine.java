package org.example.springboot;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Component("v6")
@Component
public class v6engine implements engine {
    @Override
    public void start() {
        System.out.println("v6 engine start");
    }

    @Override
    public void stop() {
        System.out.println("v6 engine stop");

    }
    @Override
    public void accelerate(){
        System.out.println("v6 engine accelerate");
    }
}
