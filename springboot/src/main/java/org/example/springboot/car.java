package org.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class car {
    @Autowired
    //@Qualifier("v6")
    public engine e;

    @Autowired
    //@Qualifier("offroad")
    public wheel w;

//    public car(engine e, wheel w){
//        this.e= e;
//        this.w= w;
//
//    }
    public void start(){
        e.start();
        w.rotate();
        e.accelerate();
        e.stop();
    }
    public void stop(){
        e.stop();
        w.brake();;
    }
}



