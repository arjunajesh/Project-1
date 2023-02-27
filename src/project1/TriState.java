package project1;

public class TriState extends NonResident {
    private String state;

    public TriState(String fname, String lname, Date dob, Major major, int credits, String state) {
        super(fname, lname, dob, major, credits);
        this.state = state;
    }


    @Override
    public double tuitionDue(int creditsEnrolled) {
        int fullCredits = 12;
        int moreCredits = 16;
        int tuitionCost = 29737;
        int universityFee = 3268;
        int perCreditHour = 966;
        int NYdiscount = 4000;
        int CTdiscount = 5000;
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

        if(state.toLowerCase().equalsIgnoreCase("NY")) {
            tuition = tuition - NYdiscount;
        }
        if(state.toLowerCase().equalsIgnoreCase("CT")) {
            tuition = tuition - CTdiscount;
        }

        return tuition;
    }
    public String getState(){
        return state.toUpperCase();
    }
}
