package com.techelevator.products;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void Candy() {

        BigDecimal test = new BigDecimal(1.50);
        Candy testObject = new Candy("Candy", "Cowtales", test, "B2");

        Assert.assertEquals("Candy", testObject.getType());
        Assert.assertEquals("Cowtales", testObject.getName());
        Assert.assertEquals(test, testObject.getPrice());
        Assert.assertEquals("B2", testObject.getSlot());



    }

}