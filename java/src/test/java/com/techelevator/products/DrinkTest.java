package com.techelevator.products;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void Drink(){

        BigDecimal test = new BigDecimal(1.25);
        Drink testObject = new Drink("Drink", "Cola", test, "C2");

        Assert.assertEquals("Drink", testObject.getType());
        Assert.assertEquals("Cola", testObject.getName());
        Assert.assertEquals(test, testObject.getPrice());
        Assert.assertEquals("C2", testObject.getSlot());

    }


}