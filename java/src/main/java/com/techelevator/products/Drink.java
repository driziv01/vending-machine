package com.techelevator.products;

import java.math.BigDecimal;

public class Drink extends Item{

    private String name;
    private String type;
    private BigDecimal price;
    private int quantity;
    private String slot;


    public Drink(String type, String name, BigDecimal price, String slot) {
        super(type, name, price, slot);

        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = 5;
        this.slot = slot;

    }





}
