import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hospital implements Comparable {
    private String name;
    private int capacity;
    private List<Resident> residentList;

    public int compareTo(Object obj) {
        Hospital hospital = (Hospital) obj;
        int comparator = this.getName().compareTo(hospital.getName());
        if (comparator == 0) {
            return this.getCapacity() - hospital.getCapacity();
        }
        return comparator;
    }

    public Hospital() {
        residentList = new ArrayList<>();
    }

    public Hospital(String name) {
        this.name = name;
        residentList = new ArrayList<>();
    }

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        residentList = new ArrayList<>();
    }

    public Hospital(String name, List<Resident> residentList) {
        this.name = name;
        this.residentList = residentList;
    }

    public Hospital(String name, int capacity, Resident preferenceList) {
        this.name = name;
        this.capacity = capacity;
        Collections.addAll(this.residentList, preferenceList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Resident> getResidentList() {
        return residentList;
    }

    public void addResident(Resident... residents) {
        Collections.addAll(residentList, residents);
    }

    @Override
    public String toString() {
//        return "{name='" + name + '\'' +
//                ", preferenceList=" + residentList + "}\n";
        return name + "(" + capacity + ")";
    }


}