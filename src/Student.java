public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major;
    private int creditCompleted;
    private String standing;
    public Student(String fname, String lname, Date dob, Major major, int credits){
        this.profile = new Profile(fname, lname, dob);
        this.creditCompleted = credits;
        this.major = major;
        if (credits < 30){
            standing = "Freshman";
        }
        else if(credits < 60){
            standing = "Sophomore";
        }
        else if(credits < 90){
            standing = "Junior";
        }
        else{
            standing = "Senior";
        }
    }
    public Student(String fname, String lname, Date dob){
        this.profile = new Profile(fname, lname, dob);
    }
    @Override
    public int compareTo(Student o) {
        return profile.compareTo(o.getProfile());
    }
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Student)){
            return false;
        }
        Student other = (Student) o;
        return this.profile.equals(other.profile);
    }
    @Override
    public String toString(){
        return getProfile().toString() + " " + major.toString() + " credits completed: " + Integer.toString(creditCompleted) +
                " (" + standing + ")";
    }
    public Profile getProfile(){
        return profile;
    }

    public void setMajor(Major major){
        this.major = major;
    }
    public Major getMajor(){
        return major;
    }
}
