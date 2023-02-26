package project1;

public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    private boolean fulltime;

    public EnrollStudent(Profile profile, int creditsEnrolled){
        this.profile = profile;
        this.creditsEnrolled = creditsEnrolled;
        this.fulltime = creditsEnrolled >= 12 ? true : false;
    }

    public boolean equals(Object o){
        if (!(o instanceof EnrollStudent)){
            return false;
        }
        EnrollStudent other = (EnrollStudent) o;
        return this.profile.equals(other.profile);
    }
    public void setCreditsEnrolled(int creditsEnrolled){
        this.creditsEnrolled = creditsEnrolled;
        this.fulltime = this.creditsEnrolled >= 12 ? true : false;
    }
    public int getCreditsEnrolled(){
        return creditsEnrolled;
    }

    public Profile getProfile() {return profile;}

    public String toString() {
        return getProfile().toString() + ": credits enrolled: " + Integer.toString(getCreditsEnrolled());
    }
    public boolean isFulltime(){
        return fulltime;
    }

}
