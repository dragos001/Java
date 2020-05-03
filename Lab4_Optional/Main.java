
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Resident residentArray[];
        residentArray = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("Resident" + i))
                .toArray(Resident[]::new);

        System.out.println("Residents = " + Arrays.toString(residentArray));

        List<Resident> residentList = new ArrayList<>();

        residentList.addAll(Arrays.asList(residentArray));

        Hospital hospitalArray[];
        hospitalArray = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("Hospital" + i, residentList))
                .toArray(Hospital[]::new);
        System.out.println("Hospitals = " + Arrays.toString(hospitalArray));

        System.out.println("Residents as a list = " + residentList);

        residentList.sort(Comparator.comparing(Resident::getName));

        System.out.println("Residents as a list(SORTED) = " + residentList);

        Set<Hospital> hospitalSet = new TreeSet<>();
        Collections.addAll(hospitalSet, hospitalArray);

        System.out.println("Hospitals as set = " + hospitalSet);

        Map<Resident, List<Hospital>> firstResidentPreferences = new HashMap<>();


        firstResidentPreferences.put(residentArray[0], Arrays.asList(hospitalArray[0], hospitalArray[1], hospitalArray[2]));
        firstResidentPreferences.put(residentArray[1], Arrays.asList(hospitalArray[0], hospitalArray[1], hospitalArray[2]));
        firstResidentPreferences.put(residentArray[2], Arrays.asList(hospitalArray[0], hospitalArray[1]));
        firstResidentPreferences.put(residentArray[3], Arrays.asList(hospitalArray[0], hospitalArray[2]));

        System.out.println("\nfirstResidentPreferences:");
        System.out.println(firstResidentPreferences);

        Map<Resident, List<Hospital>> secondResidentPreferences = new LinkedHashMap<>(firstResidentPreferences);
        System.out.println("");
        secondResidentPreferences.keySet().forEach(key -> System.out.println(key + "" + secondResidentPreferences.get(key)));

        System.out.println("\nsecondResidentPreferences:");
        System.out.println(secondResidentPreferences);




        Matching matching = new Matching(residentList.get(0));

        List<Hospital> hospitalList = new ArrayList<>();
        hospitalList.addAll(Arrays.asList(hospitalArray));

        hospitalList.get(0).setCapacity(1);
        hospitalList.get(1).setCapacity(2);
        hospitalList.get(2).setCapacity(2);

        System.out.println(matching);
        Problem problem = new Problem(residentList, hospitalList);

        Solution solution = new Solution();
        solution.setProblem(problem);

        solution.solve();

        System.out.println(solution);

        System.out.println("\nGenerating fake instances...\n");

        Faker faker = new Faker();

        int fakeHospitalNumber = faker.random().nextInt(3, 6);
        int fakeResidentNumber = faker.random().nextInt(6, 10);

        residentArray = IntStream.rangeClosed(0, fakeResidentNumber - 1)
                .mapToObj(i -> new Resident(faker.name().fullName()))
                .toArray(Resident[]::new);

        hospitalArray = IntStream.rangeClosed(0, fakeHospitalNumber - 1)
                .mapToObj(i -> new Hospital(faker.medical().hospitalName(), faker.random().nextInt(1, 4)))
                .toArray(Hospital[]::new);

        residentList.clear();
        residentList.addAll(Arrays.asList(residentArray));
        hospitalList.clear();
        hospitalList.addAll(Arrays.asList(hospitalArray));

        System.out.println("Hospitals:");
        for (Hospital hospital : hospitalList) {
            int currentCapacity = 0;
            for (int i = 0; i < fakeResidentNumber && currentCapacity < hospital.getCapacity(); i++) {
                Resident residentToAdd = residentList.get(faker.random().nextInt(0, fakeResidentNumber - 1));
                List<Resident> temporaryResidentList = new ArrayList<>();
                temporaryResidentList.addAll(hospital.getResidentList());
                for (Resident resident : temporaryResidentList) {
                    if (resident.equals(residentToAdd)) {
                        break;
                    }
                }
                hospital.addResident(residentToAdd);
                currentCapacity++;
            }
            System.out.println(hospital + " ||| " + hospital.getResidentList());
        }

        System.out.println("\nResidents:");

        for (Resident resident : residentList) {
            for (int i = 0; i < fakeHospitalNumber; i++) {
                Hospital hospitalToAdd = hospitalList.get(faker.random().nextInt(0, fakeHospitalNumber - 1));
                List<Hospital> temporaryHospitalList = new ArrayList<>();
                temporaryHospitalList.addAll(resident.getHospitalList());
                for (Hospital hospital : temporaryHospitalList) {
                    if (hospital.equals(hospitalToAdd)) {
                        break;
                    }
                }
                resident.addHospital(hospitalToAdd);
            }
            System.out.println(resident + " ||| " + resident.getHospitalList());
        }

        problem.setResidentList(residentList);
        problem.setHospitalList(hospitalList);
        problem.getMatchingList().clear();

        solution.setProblem(problem);
        solution.solve();

      

        if (solution.validate() == true) {
            System.out.println("The matching is stable");
        } else {
            System.out.println("The matching is not stable");
        }

    }


}