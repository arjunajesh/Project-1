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
        if(this.lname.compareToIgnoreCase(o.lname) != 0){
            return this.lname.compareToIgnoreCase(o.lname);
        }
        else{
            if(this.fname.compareToIgnoreCase(o.fname)!=0){
                return this.fname.compareToIgnoreCase(o.fname);
            }
            else{
                return dob.compareTo(o.getDob());
            }
        }
    }
    public Date getDob(){
        return dob;
    }
    @Override
    public boolean equals(Object o){

        if(!(o instanceof Profile)){
            return false;
        }
        Profile other = (Profile) o;

        if (this.lname.toLowerCase().equals(other.lname.toLowerCase()) && this.fname.toLowerCase().equals(other.fname.toLowerCase()) && this.dob.equals(other.dob)){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return fname + " " + lname + " " + dob.toString();
    }
}
