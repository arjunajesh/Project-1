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
    public double tuitionDue(int creditsEnrolled) { // resident students are eligible for scholarships!
        double tuition = 0.00;
        if(creditsEnrolled >= 12) { // full time student
            if(creditsEnrolled > 16) { // additional pay for over 16 credits
                tuition = 12536 + 3268 + (404 * (creditsEnrolled - 16));
            }
            else {
                tuition = 12536 + 3268;
            }
        }
        else { // part time student
            tuition = (404 * creditsEnrolled) + (0.8 * 3268);
        }
        return tuition;
    }

    @Override
    public boolean isResident() {
        return true;
    }

    public void setScholarship(int scholarship){
        this.scholarship = scholarship;
    }


}
