public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major;
    private int creditCompleted;
    public Student(String fname, String lname, Date dob, String major, int credits){
        this.profile = new Profile(fname, lname, dob);
        this.creditCompleted = credits;

    }
    @Override
    public int compareTo(Student o) { // I HAVE NO IDEA IF THIS IS WHAT IM SUPPOSED TO DO
        if(this.equals(o)){
            return 1;
        }
        else return 0;
    }
}
