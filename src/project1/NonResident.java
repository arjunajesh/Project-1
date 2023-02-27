package project1;

public class NonResident extends Student{

    public NonResident(String fname, String lname, Date dob, Major major, int credits) {
        super(fname, lname, dob, major, credits);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        int fullCredits = 12;
        int moreCredits = 16;
        int tuitionCost = 29737;
        int universityFee = 3268;
        int perCreditHour = 966;
        double tuition = 0.00;
        if(creditsEnrolled >= fullCredits) { // full time
            if(creditsEnrolled > moreCredits) {
                tuition = tuitionCost + universityFee + (perCreditHour * (creditsEnrolled - moreCredits));
            }
            else {
                tuition = tuitionCost + universityFee;
            }
        }
        else { // part time
            tuition = (perCreditHour * creditsEnrolled) + (0.8 * universityFee);
        }
        return tuition;
    }

    @Override
    public boolean isResident() {
        return false;
    }
}
