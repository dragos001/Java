package Lab2;

public class Depot {
    private String name;
    private Vehicle[] vehicles;
    int i=0;
    public Depot(String name){
        this.name = name;
    }

    public Depot(){}


        public void setVehicles(Vehicle ... vehicles) {
        this.vehicles = vehicles;
        for(Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    public void getVehicles() {
        for(Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }

    public void getDepName(){ System.out.println(name); }
    public String toString(){ return name; }
    }
