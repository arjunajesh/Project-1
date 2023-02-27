package project1;

public class NonResident extends Student{

    private static final int MIN_CREDITS_FULLTIME = 12;
    private static final int ADDITIONAL_CREDITS = 16;
    private static final int TUITION_COST = 29737;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int PER_CREDIT_HOUR_COST = 966;
    public NonResident(String fname, String lname, Date dob, Major major, int credits) {
        super(fname, lname, dob, major, credits);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuition = 0.00;
        if(creditsEnrolled >= MIN_CREDITS_FULLTIME) { // full time
            if(creditsEnrolled > ADDITIONAL_CREDITS) {
                tuition = TUITION_COST + UNIVERSITY_FEE + (PER_CREDIT_HOUR_COST * (creditsEnrolled - ADDITIONAL_CREDITS));
            }
            else {
                tuition = TUITION_COST + UNIVERSITY_FEE;
            }
        }
        else { // part time
            tuition = (PER_CREDIT_HOUR_COST * creditsEnrolled) + (0.8 * UNIVERSITY_FEE);
        }
        return tuition;
    }

    @Override
    public boolean isResident() {
        return false;
    }
}
