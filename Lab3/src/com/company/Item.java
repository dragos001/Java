package com.company;

public interface Item {
    String getName();
    double getValue();
    double getWeight();
    default double profitFactor(){
        return getValue()/getWeight();
    }
}
