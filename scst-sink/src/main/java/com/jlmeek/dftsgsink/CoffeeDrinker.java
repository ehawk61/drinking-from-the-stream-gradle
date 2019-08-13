package com.jlmeek.dftsgsink;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;

@EnableBinding(Sink.class)
@MessageEndpoint
public class CoffeeDrinker {

    @StreamListener(value = Sink.INPUT)
    private void drink(RetailCoffee coffee) {
        System.out.println(coffee);
    }

}

