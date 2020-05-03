import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Problem problem;

    public Solution() {
    }

    public Solution(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public void solve() {
        
    }

    public boolean validate(){
        boolean ok=true;
        for(Matching matching : problem.getMatchingList()){
            if(!matching.getResident().getHospitalList().get(0).equals(matching.getHospital())){
                return false;
            }
            if(!matching.getHospital().getResidentList().get(0).equals(matching.getResident())){
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Solution{\n" + problem.getMatchingList() + "\n}";
    }

}