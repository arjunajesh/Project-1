/**
 * Class for Student Object
 * @author Arjun Ajesh, Nathan Roh
 */
public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major;
    private int creditCompleted;
    private String standing;

    public static void main(String[] args){
        final String PASSED = "PASSED";
        final String FAILED = "FAILED";

        Student s1 = new Student("Bob", "Marley", new Date("6/12/1994"));
        Student s2 = new Student("Alfred", "Marley", new Date("6/12/1994"));
        System.out.println("Testing compareTo: " + s1.getProfile().toString() + " and " + s2.getProfile().toString());
        System.out.println(s1.compareTo(s2) > 0 ? PASSED:FAILED);

        s1 = new Student("Bob", "Marley", new Date("6/12/1994"));
        s2 = new Student("Bob", "Farley", new Date("6/12/1994"));
        System.out.println("Testing compareTo: " + s1.getProfile().toString() + " and " + s2.getProfile().toString());
        System.out.println(s1.compareTo(s2) > 0 ? PASSED:FAILED);

        s1 = new Student("Bob", "Marley", new Date("6/12/1992"));
        s2 = new Student("Bob", "Marley", new Date("6/12/1994"));
        System.out.println("Testing compareTo: " + s1.getProfile().toString() + " and " + s2.getProfile().toString());
        System.out.println(s1.compareTo(s2) < 0 ? PASSED:FAILED);

        s1 = new Student("Bob", "Marley", new Date("6/12/1994"));
        s2 = new Student("Bob", "Marley", new Date("6/12/1994"));
        System.out.println("Testing compareTo: " + s1.getProfile().toString() + " and " + s2.getProfile().toString());
        System.out.println(s1.compareTo(s2) == 0 ? PASSED:FAILED);

    }

    /**
     * Constructor for Student Class
     * @param fname
     * @param lname
     * @param dob
     * @param major
     * @param credits
     */
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

    /**
     * Constructor for Student Class
     * @param fname first name of student
     * @param lname last name of student
     * @param dob date of birth of student
     */
    public Student(String fname, String lname, Date dob){
        this.profile = new Profile(fname, lname, dob);
    }

    /**
     * Compares Student instance to another instance by first name, last name, and date of birth
     * @param o the object to be compared.
     * @return Returns 0 if equal, integer less than 0 if instance is less, greater than 0 if instance is greater
     */
    @Override
    public int compareTo(Student o) {
        return profile.compareTo(o.getProfile());
    }

    /**
     *
     * @param o object to be compared to
     * @return true if students are equal, false if not
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Student)){
            return false;
        }
        Student other = (Student) o;
        return this.profile.equals(other.profile);
    }

    /**
     * Converts Student object to String
     * @return string describing Student
     */
    @Override
    public String toString(){
        return getProfile().toString() + " " + major.toString() + " credits completed: " + Integer.toString(creditCompleted) +
                " (" + standing + ")";
    }

    /**
     *
     * @return Profile of student
     */
    public Profile getProfile(){
        return profile;
    }

    /**
     *
     * @param major
     */
    public void setMajor(Major major){
        this.major = major;
    }

    /**
     *
     * @return major of student
     */
    public Major getMajor(){
        return major;
    }

    /**
     *
     * @return string standing of the student (Freshman, Sophomore, Junior, Senior)
     */
    public String getStanding() {
        return standing;
    }

    /**
     *
     * @return School that student is in (String)
     */
    public String getSchool(){
        return major.getSchool();
    }
}
