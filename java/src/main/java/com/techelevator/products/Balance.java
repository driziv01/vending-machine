package com.techelevator.products;

import java.math.BigDecimal;

public class Balance {


     private BigDecimal balance = new BigDecimal(0.00);



     public void zeroBalance(){

         this.balance = new BigDecimal(0.00);
     }


    public void addMoney(BigDecimal deposit){
         balance = this.balance.add(deposit);

     }

     public void purchaseItem (BigDecimal purchase){
         balance = this.balance.subtract(purchase);
     }

    public BigDecimal getBalance() {
        return balance;
    }

}


