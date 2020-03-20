package Lab2;

public class Ex1 {
    public static void main(String[] args){

        Client c1 = new Client("Client1",1);
        Client c2 = new Client("Client2",2);
        Client c3 = new Client("Client3",3);
        Vehicle v1 = new Vehicle("Masina1");
        Vehicle v2 = new Vehicle("Masina2");
        Vehicle v3 = new Vehicle("Masina3");
        Depot d1 = new Depot("Depo1");
        Depot d2 = new Depot("Depo2");
        Tour t1 = new Tour();
        //Ataseaza vehicule in depou
        d1.setVehicles(v1,v2);
        d2.setVehicles(v3);
        //Afiseaza vehiculele depou-lui d1
        //d1.getVehicles();

        //Adauga clienti si
        t1.setClients(c2,c1,c3);
        t1.setVehicle(v1);
        //Tur format dintr-un vehicul si mai multi clienti
        t1.startTour();

    }
}
