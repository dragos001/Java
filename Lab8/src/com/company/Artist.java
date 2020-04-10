package com.company;

public class Artist {
    private String name;
    private String country;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

}