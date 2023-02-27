package project1;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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

    public void printEnrollment(){
        for(int i = 0; i < size; i++) {
            if(this.enrollStudents[i] != null) {
                System.out.println(enrollStudents[i].toString());
            }
        }
    }

    public void printTuition(Roster roster){
        for(int i = 0; i < size; i++) {
            EnrollStudent es = enrollStudents[i];
            Student s = roster.getStudent(es.getProfile());
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
            System.out.println(s.getProfile() + " " + getStudentInfo(s) + " enrolled " +
                    es.getCreditsEnrolled() + " credits: tuition due: $" + decimalFormat.format(s.tuitionDue(es.getCreditsEnrolled())));
        }
    }
    public String getStudentInfo(Student s){
        if(s instanceof Resident){
            return "(Resident)";
        }
        else if(s instanceof International){
            return "(International student" + (((International) s).isStudyAbroad() ? "study abroad)":")");
        }
        else if(s instanceof TriState){
            return "(Tri-state " + ((TriState) s).getState().toUpperCase() + ")";
        }
        else if(s instanceof NonResident){
            return "(Non-Resident)";
        }
        else return "";
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
