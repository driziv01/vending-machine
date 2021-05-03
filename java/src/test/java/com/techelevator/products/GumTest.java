package com.techelevator.products;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void Gum() {
//        BigDecimal test = new BigDecimal(1.00);
//        Gum testObject = new Gum("Gum", "Little League Chew", test, "D2");
//
//        Gum actualResult = testObject;
//        Gum expectedResult = new Gum("Gum", "Little League Chew", test, "D2");
//        Assert.assertEquals(expectedResult,actualResult);

        BigDecimal test = new BigDecimal(.75);
        Gum testObject = new Gum("Gum", "Eclipse", test, "D2");
       // int gumQuantity = 6;

        //need 4 different asserts:

        Assert.assertEquals("Gum", testObject.getType()); // type object compare with what you think value should be
        Assert.assertEquals("Eclipse", testObject.getName()); // type object compare with what you think value should be
        Assert.assertEquals(test, testObject.getPrice()); // type object compare with what you think value should be
        Assert.assertEquals("D2", testObject.getSlot()); // type object compare with what you think value should be

        //testObject.getType();

       // testObject.getQuantity();

       // Assert.assertEquals(gumQuantity,);


    }



}