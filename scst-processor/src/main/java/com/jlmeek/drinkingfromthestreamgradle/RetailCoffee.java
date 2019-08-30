package com.jlmeek.drinkingfromthestreamgradle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RetailCoffee {
    enum CoffeeState {
        WHOLE_BEAN,
        GROUND
    }

    private String id, name;
    private CoffeeState state;
}

