package com.techelevator.view;

public class VendingItem {

    private String slot;
    private String name;
    private double price;
    private String productType;
    private int quantity = 5;
    private boolean soldOut = false;


    public VendingItem(String slot, String name, double price, String productType, int quantity) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.quantity = quantity;
    }

    public VendingItem(String slot, String name, double price, String productType) {
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "VendingItem{" +
                "slot='" + slot + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productType='" + productType + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }

}
