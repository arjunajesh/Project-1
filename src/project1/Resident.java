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
        int fullCredits = 12;
        int moreCredits = 16;
        int tuitionCost = 12536;
        int universityFee = 3268;
        int perCreditHour = 404;
        double tuition = 0.00;
        if(creditsEnrolled >= fullCredits) { // full time student
            if(creditsEnrolled > moreCredits) { // additional pay for over 16 credits
                tuition = tuitionCost + universityFee + (perCreditHour * (creditsEnrolled - moreCredits));
            }
            else {
                tuition = tuitionCost + universityFee;
            }
        }
        else { // part time student
            tuition = (perCreditHour * creditsEnrolled) + (0.8 * universityFee);
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
