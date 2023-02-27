package project1;

public class TriState extends NonResident {
    private String state;
    private static final int MIN_CREDITS_FULLTIME = 12;
    private static final int ADDITIONAL_CREDITS = 16;
    private static final int TUITION_COST = 29737;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int PER_CREDIT_HOUR_COST = 966;
    private static final int NY_DISCOUNT = 4000;
    private static final int CT_DISCOUNT = 5000;
    public TriState(String fname, String lname, Date dob, Major major, int credits, String state) {
        super(fname, lname, dob, major, credits);
        this.state = state;
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

        if(state.toLowerCase().equalsIgnoreCase("NY") && creditsEnrolled >= MIN_CREDITS_FULLTIME) {
            tuition = tuition - NY_DISCOUNT;
        }
        if(state.toLowerCase().equalsIgnoreCase("CT") && creditsEnrolled >= MIN_CREDITS_FULLTIME) {
            tuition = tuition - CT_DISCOUNT;
        }

        return tuition;
    }
    public String getState(){
        return state.toUpperCase();
    }
}
