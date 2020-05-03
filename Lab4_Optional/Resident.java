import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resident {
    private String name;
    private List<Hospital> hospitalList;

    public Resident() {
        hospitalList = new ArrayList<>();
    }

    public Resident(String name) {
        this.name = name;
        hospitalList = new ArrayList<>();
    }

    public Resident(String name, List<Hospital> hospitalList) {
        this.name = name;
        this.hospitalList = hospitalList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void addHospital(Hospital... hospitals) {
        Collections.addAll(hospitalList, hospitals);
    }

    @Override
    public String toString() {
        return /*"Resident name='" +*/ name /*+ "'" + hospitalList*/;
    }


}

