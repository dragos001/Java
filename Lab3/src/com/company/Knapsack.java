package com.company;

import java.util.*;

public class Knapsack {
    private double capacity;
    private List<Item> items = new ArrayList<>();

    public Knapsack(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void addItem(Item item){
        items.add(item);
    }
    private void naturalOrder(List<Item> items){
        items.sort(Comparator.comparing(Item::getName));
    }


    @Override
    public String toString() {
        naturalOrder(items);
        return "Knapsack{" +
                "capacity=" + capacity +
                ", items=" + items +
                '}';
    }

}
