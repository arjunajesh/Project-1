package project1;

public class International extends NonResident{ //comment
    private boolean isStudyAbroad;

    public International(String fname, String lname, Date dob, Major major, int credits, boolean isStudyAbroad) {
        super(fname, lname, dob, major, credits);
        this.isStudyAbroad = isStudyAbroad;
    }
}
