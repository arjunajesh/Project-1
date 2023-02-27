package project1;

public class Resident extends Student{

    private int scholarship;
    private static final int MIN_CREDITS_FULLTIME = 12;
    private static final int ADDITIONAL_CREDITS = 16;
    private static final int TUITION_COST = 12536;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int PER_CREDIT_HOUR_COST = 404;
    public Resident(String fname, String lname, Date dob, Major major, int credits) {
        super(fname, lname, dob, major, credits);
    }

    public Resident(String fname, String lname, Date dob){
        super(fname, lname, dob);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) { // resident students are eligible for scholarships!
        double tuition = 0.00;
        if(creditsEnrolled >= MIN_CREDITS_FULLTIME) { // full time student
            if(creditsEnrolled > ADDITIONAL_CREDITS) { // additional pay for over 16 credits
                tuition = TUITION_COST + UNIVERSITY_FEE + (PER_CREDIT_HOUR_COST * (creditsEnrolled - ADDITIONAL_CREDITS));
            }
            else {
                tuition = TUITION_COST + UNIVERSITY_FEE;
            }
        }
        else { // part time student
            tuition = (PER_CREDIT_HOUR_COST * creditsEnrolled) + (0.8 * UNIVERSITY_FEE);
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
