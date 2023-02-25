package project1;

public class TriState extends NonResident {
    private String state;

    public TriState(String fname, String lname, Date dob, Major major, int credits, String state) {
        super(fname, lname, dob, major, credits);
        this.state = state;
    }
}
