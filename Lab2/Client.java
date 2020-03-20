package Lab2;

public class Client  {
    private int time;
    private String name;

    public Client(String name,int time) {
        this.name = name;
        this.time = time;
    }

    public void setTime(int time ) {
        if(time > 0 )
            this.time = time;
    }
    public void setName(String name){
        this.name = name;
    }

    public void getName(){
        System.out.println(name);
    }
    public int getTime(){ return time; }
    public String toString(){
        return name;
    }

}
