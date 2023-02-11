public class Profile implements Comparable<Profile>{
    private String lname;
    private String fname;
    private Date dob;

    public Profile(String fname, String lname, Date dob){
        this.lname = lname;
        this.fname = fname;
        this.dob = dob;
    }
    @Override
    public int compareTo(Profile o) {
        return 1;
    }
    @Override
    public boolean equals(Object o){

        if(!(o instanceof Profile)){
            return false;
        }
        Profile other = (Profile) o;
        System.out.println("we got to the profile class");

        if (this.lname.equals(other.lname) && this.fname.equals(other.fname) && this.dob.equals(other.dob)){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return fname + " " + lname + " " + dob.toString();
    }
}
