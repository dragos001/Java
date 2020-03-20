package com.company;

public class Vehicle extends Depot {

    private String name;
    private Depot depot;
    private VehicleType type;

    protected void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Vehicle(String name) {
        this.name = name;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public void getName() {
        System.out.println(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Depot getDepot() {
        return depot;
    }

    public String toString() {
        return name;
    }

}