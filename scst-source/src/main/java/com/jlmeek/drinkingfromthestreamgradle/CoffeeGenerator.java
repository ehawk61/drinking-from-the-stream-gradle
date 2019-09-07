package com.jlmeek.drinkingfromthestreamgradle;

import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
@RefreshScope
@Slf4j
class CoffeeGenerator {
    @Value("${coffee.types}")
    private String[] names;

    private final Random rnd = new Random();
    private int i = 0;

    @PostConstruct
    private void showConfig() {
        log.info("List of Available Coffees: " + String.join(",", names));
    }

    WholesaleCoffee generate() {
        i = rnd.nextInt(names.length);

        WholesaleCoffee wCoffee = new WholesaleCoffee(UUID.randomUUID().toString(), names[i]);
        return wCoffee;
    }
}