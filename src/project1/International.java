package project1;

public class International extends NonResident{
    private boolean isStudyAbroad;
    private static final int MIN_CREDITS_FULLTIME = 12;
    private static final int ADDITIONAL_CREDITS = 16;
    private static final int TUITION_COST = 29737;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int HEALTH_INSURANCE_FEE = 2650;
    private static final int PER_CREDIT_HOUR_COST = 966;
    private static final int STUDYABROAD_MAX_CREDITS = 12;
    private static final int STUDYABROAD_MIN_CREDITS = 3;
    private static final int INTERNATIONAL_MAX_CREDITS = 24;
    private static final int INTERNATIONAL_MIN_CREDITS = 12;
    public International(String fname, String lname, Date dob, Major major, int credits, boolean isStudyAbroad) {
        super(fname, lname, dob, major, credits);
        this.isStudyAbroad = isStudyAbroad;
    }

    @Override
    public boolean isValid(int creditEnrolled){
        if(isStudyAbroad){
            return creditEnrolled <= STUDYABROAD_MAX_CREDITS && creditEnrolled >= STUDYABROAD_MIN_CREDITS;
        }
        else{
            return creditEnrolled >= INTERNATIONAL_MIN_CREDITS && creditEnrolled <= INTERNATIONAL_MAX_CREDITS;
        }
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuition = 0.00;
        if(creditsEnrolled >= MIN_CREDITS_FULLTIME) {
            if(isStudyAbroad) {
                tuition = UNIVERSITY_FEE + HEALTH_INSURANCE_FEE;
            }
            else { // NOT study abroad
                if(creditsEnrolled > ADDITIONAL_CREDITS) {
                    tuition = TUITION_COST + UNIVERSITY_FEE + HEALTH_INSURANCE_FEE + (PER_CREDIT_HOUR_COST * (creditsEnrolled - ADDITIONAL_CREDITS));
                }
                else {
                    tuition = TUITION_COST + UNIVERSITY_FEE + HEALTH_INSURANCE_FEE;
                }
            }
        }
        else { // <12 credits entails that the student is studying abroad
            tuition = UNIVERSITY_FEE + HEALTH_INSURANCE_FEE;
        }

        return tuition;
    }

    public boolean isStudyAbroad(){
        return isStudyAbroad;
    }

}
