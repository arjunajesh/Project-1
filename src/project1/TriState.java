package project1;

public class TriState extends NonResident {
    private String state;

    public TriState(String fname, String lname, Date dob, Major major, int credits, String state) {
        super(fname, lname, dob, major, credits);
        this.state = state;
    }


    @Override
    public String getType(){
        return "Tri-state " + state;
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

        if(getType().toLowerCase().equalsIgnoreCase("Tri-state NY")) {
            tuition = tuition - 4000;
        }
        if(getType().toLowerCase().equalsIgnoreCase("Tri-state CT")) {
            tuition = tuition - 5000;
        }

        return tuition;
    }
}
