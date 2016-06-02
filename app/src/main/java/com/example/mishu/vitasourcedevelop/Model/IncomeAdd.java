package com.example.mishu.vitasourcedevelop.Model;

/**
 * Created by Murtuza on 5/28/2016.
 */
public class IncomeAdd {
    String name;
    String amount;
    public IncomeAdd(String name,String amount){
        this.name=name;
        this.amount=amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
