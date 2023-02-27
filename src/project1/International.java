package project1;

public class International extends NonResident{
    private boolean isStudyAbroad;
    public International(String fname, String lname, Date dob, Major major, int credits, boolean isStudyAbroad) {
        super(fname, lname, dob, major, credits);
        this.isStudyAbroad = isStudyAbroad;
    }

    @Override
    public boolean isValid(int creditEnrolled){
        int SAmin = 3; // study abroad min
        int SAmax = 12; // study abroad max
        int NSAmin = 12; // not study abroad min
        int NSAmax = 24; // not study abroad max
        if(isStudyAbroad){
            return creditEnrolled <= SAmax && creditEnrolled >= SAmin;
        }
        else{
            return creditEnrolled >= NSAmin && creditEnrolled <= NSAmax;
        }
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        int fullCredits = 12;
        int tuitionCost = 29737;
        int universityFee = 3268;
        int healthFee = 2650;
        double tuition = 0.00;
        if(creditsEnrolled >= fullCredits) {
            if(isStudyAbroad) {
                tuition = universityFee + healthFee;
            }
            else { // NOT study abroad
                tuition = tuitionCost + universityFee + healthFee;
            }
        }
        else { // <12 credits entails that the student is studying abroad
            tuition = universityFee + healthFee;
        }

        return tuition;
    }

    public boolean isStudyAbroad(){
        return isStudyAbroad;
    }

}
