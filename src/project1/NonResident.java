package project1;

public class NonResident extends Student{

    private final String STUDENT_TYPE = "NonResident";
    public NonResident(String fname, String lname, Date dob, Major major, int credits) {
        super(fname, lname, dob, major, credits);
    }

    @Override
    public String getType() {
        return STUDENT_TYPE;
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        return 0;
    }

    @Override
    public boolean isResident() {
        return false;
    }
}
