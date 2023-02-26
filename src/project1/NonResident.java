package project1;

public class NonResident extends Student{

    public NonResident(String fname, String lname, Date dob, Major major, int credits) {
        super(fname, lname, dob, major, credits);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuition = 0;
        if(creditsEnrolled >= 12) { // full time
            if(creditsEnrolled > 16) {
                tuition = 29737 + 3268 + (966 * (creditsEnrolled - 16));
            }
            else {
                tuition = 29737 + 3268;
            }
        }
        else { // part time
            tuition = (966 * creditsEnrolled) + (0.8 * 3268);
        }
        return tuition;
    }

    @Override
    public boolean isResident() {
        return false;
    }
}
