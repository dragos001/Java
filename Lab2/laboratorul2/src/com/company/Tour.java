package com.company;

public class Tour {
    private Vehicle vehicle;
    private Client[] clients;
    private Client aux;
    public Tour() {
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setClients(Client... clients) {
        this.clients = clients;
    }

    public void startTour() {
        System.out.print(vehicle.toString() + " : ");
        System.out.print(vehicle.getDepot().toString() + " - > ");

        for(int i = 0 ; i < clients.length;i++) {
            for(int j = 0 ;j<clients.length -1 ; j++ ) {
                if(clients[i].getTime() < clients[j].getTime()) {
                    aux = clients[j];
                    clients[j] = clients[i];
                    clients[i] = aux;
                }
            }
        }

        for (Client client : clients) {
            System.out.print("( " + client.toString() + " , " + client.getTime() + " ) - > ");
        }
        System.out.print(vehicle.getDepot().toString());
    }


    public void getVehicle() {
        System.out.println(vehicle.toString());
    }

    public void getClients() {
        for (Client c : clients) {
            System.out.println(c.toString());
        }

    }

}
