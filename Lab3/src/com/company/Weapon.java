package com.company;

public class Weapon implements Item {
    private WeaponType type;
    private double weight;
    private double value;

    public enum WeaponType {
        SWORD, PISTOL, RIFLES
    }

    public Weapon(WeaponType type, double weight, double value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String getName() {
        return String.valueOf(type);
    }


    @Override
    public String toString() {
        return "Weapon{" +
                "type=" + type +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
