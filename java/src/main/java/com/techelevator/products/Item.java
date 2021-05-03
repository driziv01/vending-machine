package com.techelevator.products;

import java.math.BigDecimal;

public abstract class Item {


    private String type;
    private String name;
    private BigDecimal price;
    private int quantity = 5;
    private String slot;
    private boolean soldOut = false;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSlot() {
        return slot;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Item(String type, String name, BigDecimal price, String slot) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = 5;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", slot='" + slot + '\'' +
                '}';
    }
}
