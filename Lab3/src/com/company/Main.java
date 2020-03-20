package com.company;

public class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(10);
        Book book1 = new Book("Dragon Rising", 3, 5);
        Book book2 = new Book("A Blade in the Dark", 3, 5);
        //System.out.println(book1.profitFactor());
        Food food1 = new Food("Cabbage", 2, 4);
        Food food2 = new Food("Rabbit", 2, 4);
        //System.out.println(food1.profitFactor());
        Weapon weapon = new Weapon(Weapon.WeaponType.SWORD, 5, 10);
        //System.out.println(weapon.getName());
        //System.out.println(weapon.profitFactor());
        knapsack.addItem(weapon);
        knapsack.addItem(book1);
        knapsack.addItem(food2);
        System.out.println(knapsack.toString());
    }
}

