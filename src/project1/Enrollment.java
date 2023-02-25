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
        int index = find(enrollStudent);
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

    }
    public boolean contains(EnrollStudent enrollStudent){
        return true;
    }
    public int find(EnrollStudent s){
        for (int i = 0; i < size; i++){
            if (s.equals(enrollStudents[i])) {
                return i;
            }
        }
        return -1;
    }

    public void print(){}
}
