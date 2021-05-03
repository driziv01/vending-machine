package com.techelevator.products;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BalanceTest {

    @Test
    public void zeroBalance() {

        Balance testObject = new Balance();
        BigDecimal test = new BigDecimal(5);
        testObject.addMoney(test);
        testObject.zeroBalance();

        BigDecimal actualResult = testObject.getBalance();
        BigDecimal expectedResult = new BigDecimal(0);
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void addMoney() {
        Balance testObject = new Balance();
        BigDecimal test = new BigDecimal(5);
        testObject.addMoney(test);
        BigDecimal actualResult = testObject.getBalance();
        BigDecimal expectedResult = new BigDecimal(5);
        Assert.assertEquals(expectedResult,actualResult);

//
//        double tester = Double.parseDouble(String.valueOf());
//        double totalMoneyTest = Double.parseDouble(String.valueOf(currentBalance.getBalance()));

    }

    @Test
    public void purchaseItem() {
        Balance testObject = new Balance();
        BigDecimal test1 = new BigDecimal(5);
        testObject.addMoney(test1);
        BigDecimal test = new BigDecimal(5);
        testObject.purchaseItem(test);
        BigDecimal actualResult = testObject.getBalance();
        BigDecimal expectedResult = new BigDecimal(0);
        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void getBalance() {
    }
}