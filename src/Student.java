public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major;
    private int creditCompleted;
    public Student(String fname, String lname, Date dob, Major major, int credits){
        this.profile = new Profile(fname, lname, dob);
        this.creditCompleted = credits;
    }
    public Student(String fname, String lname, Date dob){
        this.profile = new Profile(fname, lname, dob);
    }
    @Override
    public int compareTo(Student o) {
        if(this.equals(o)){
            return 1;
        }
        else return 0;
    }
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Student)){
            return false;
        }
        Student other = (Student) o;
        return this.profile.equals(other.profile);
    }

    public void setMajor(Major major){
        this.major = major;
    }
}
