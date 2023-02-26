package project1;

public class International extends NonResident{
    private boolean isStudyAbroad;
    public International(String fname, String lname, Date dob, Major major, int credits, boolean isStudyAbroad) {
        super(fname, lname, dob, major, credits);
        this.isStudyAbroad = isStudyAbroad;
    }

    @Override
    public boolean isValid(int creditEnrolled){
        if(isStudyAbroad){
            return creditEnrolled <= 12 && creditEnrolled >= 3;
        }
        else{
            return creditEnrolled >=12 && creditEnrolled <= 24;
        }
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuition = 0;
        if(creditsEnrolled >= 12) {
            if(isStudyAbroad) {
                tuition = 3268 + 2650;
            }
            else { // NOT study abroad
                tuition = 29737 + 3268 + 2650;
            }
        }
        else { // <12 credits entails that the student is studying abroad
            tuition = 3268 + 2650;
        }

        return tuition;
    }

    public boolean isStudyAbroad(){
        return isStudyAbroad;
    }

}
