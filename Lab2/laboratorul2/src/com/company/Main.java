package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Client c1 = new Client("Client1",1);
        Client c2 = new Client("Client2",2);
        Client c3 = new Client("Client3",3);
        Vehicle v1 = new Vehicle("BMW");
        Vehicle v2 = new Vehicle("AUDI");
        Vehicle v3 = new Vehicle("MERCEDES-BENZ");
        Depot d1 = new Depot("DEPOZIT1");
        Depot d2 = new Depot("DEPOZIT2");
        Tour t1 = new Tour();

        d1.setVehicles(v1,v2);
        d2.setVehicles(v3);
        t1.setClients(c2,c1,c3);
        t1.setVehicle(v1);
        t1.startTour();
    }
}
