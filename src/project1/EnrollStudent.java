package project1;

public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    public EnrollStudent(Profile profile, int creditsEnrolled){ // comment
        this.profile = profile;
        this.creditsEnrolled = creditsEnrolled;
    }

    public boolean equals(Object o){
        if (!(o instanceof Student)){
            return false;
        }
        EnrollStudent other = (EnrollStudent) o;
        return this.profile.equals(other.profile);
    }
    public void setCreditsEnrolled(int creditsEnrolled){
        this.creditsEnrolled = creditsEnrolled;
    }
    public int getCreditsEnrolled(){
        return creditsEnrolled;
    }

}
