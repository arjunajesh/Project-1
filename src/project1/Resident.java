package project1;

public class Resident extends Student{

    private int scholarship;
    public Resident(String fname, String lname, Date dob, Major major, int credits) {
        super(fname, lname, dob, major, credits);
    }

    public Resident(String fname, String lname, Date dob){
        super(fname, lname, dob);
    }

    @Override
    public String getType() {
        return "Resident";
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
