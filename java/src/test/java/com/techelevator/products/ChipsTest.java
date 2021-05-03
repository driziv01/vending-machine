package com.techelevator.products;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test
    public void Chips(){

        BigDecimal test = new BigDecimal(1.45);
        Chips testObject = new Chips("Chips", "Stackers", test, "A2");

        Assert.assertEquals("Chips", testObject.getType());
        Assert.assertEquals("Stackers", testObject.getName());
        Assert.assertEquals(test, testObject.getPrice());
        Assert.assertEquals("A2", testObject.getSlot());




    }




}