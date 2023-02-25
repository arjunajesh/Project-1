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
    public String getType(){

        return "International student" + (isStudyAbroad ? "study abroad)" : "");
    }
}
