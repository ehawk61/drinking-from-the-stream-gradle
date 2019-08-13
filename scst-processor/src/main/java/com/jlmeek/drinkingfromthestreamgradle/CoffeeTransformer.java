package com.jlmeek.drinkingfromthestreamgradle;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Random;

@EnableBinding(Processor.class)
@MessageEndpoint
public class CoffeeTransformer {
    private final Random rnd = new Random();

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    RetailCoffee transform(WholesaleCoffee wCoffee) {

        RetailCoffee rCoffee = new RetailCoffee(wCoffee.getId(),
                wCoffee.getName(),
                rnd.nextInt(2) == 0 ? RetailCoffee.CoffeeState.WHOLE_BEAN : RetailCoffee.CoffeeState.GROUND);

        System.out.println(rCoffee);

        return rCoffee;
    }
}
