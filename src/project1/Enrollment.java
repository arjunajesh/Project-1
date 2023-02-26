package project1;

public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;
    public static final int CAPACITY = 4;


    public Enrollment(){
        this.size = 0;
        this.enrollStudents = new EnrollStudent[CAPACITY];

    }
    public void add(EnrollStudent enrollStudent){
        int index = find(enrollStudent.getProfile());
        if(index != -1){
            enrollStudents[index].setCreditsEnrolled(enrollStudent.getCreditsEnrolled());
        }
        else {
            if (size == enrollStudents.length) {
                grow();
            }
            enrollStudents[size] = enrollStudent;
            size++;
        }
    }
    public void grow(){
        EnrollStudent[] newEnrollment = new EnrollStudent[enrollStudents.length + CAPACITY];
        for(int i = 0; i < enrollStudents.length; i++){
            newEnrollment[i] = enrollStudents[i];
        }
        enrollStudents = newEnrollment;
    }
    public void remove(EnrollStudent enrollStudent){
        if(find(enrollStudent.getProfile()) == -1) {
            System.out.println("Student not found (CHANGE LATER)");
        }
        else {
            int pivot = find(enrollStudent.getProfile());
            for(int i = pivot; i < size; i++) {
                enrollStudents[i] = enrollStudents[i+1];
            }
            enrollStudents[size] = null;
            size--;
            System.out.println("Student dropped from enrollment! (CHANGE LATER)");
        }
    }
    public boolean contains(EnrollStudent enrollStudent){
        return true;
    }
    public int find(Profile p){
        for (int i = 0; i < size; i++){
            if (p.equals(enrollStudents[i].getProfile())) {
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for(int i = 0; i < size; i++) {
            if(this.enrollStudents[i] != null) {
                System.out.println(enrollStudents[i].toString());
            }
        }
    }

    public void printTuition(){
        for(int i = 0; i < size; i++) {
            if(this.enrollStudents[i] != null) {
                System.out.println();
            }
        }
    }
    public EnrollStudent getEnrolledStudent(Profile p){
        int i = find(p);
        if(i == -1){
            return null;
        }
        else{
            return enrollStudents[i];
        }
    }
}
