package com.example.demo;

public class Player {
    int id;
    String name;
    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
