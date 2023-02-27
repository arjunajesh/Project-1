package project1;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;
    private static final int CAPACITY = 4;


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

            enrollStudents[size] = enrollStudent;
            size++;
            if (size == enrollStudents.length) {
                grow();
            }
        }
    }
    public void grow(){
        EnrollStudent[] newEnrollment = new EnrollStudent[size + CAPACITY];
        for(int i = 0; i < enrollStudents.length; i++){
            newEnrollment[i] = enrollStudents[i];
        }
        enrollStudents = newEnrollment;
    }
    public void remove(EnrollStudent enrollStudent){
        if(find(enrollStudent.getProfile()) == -1) {
            System.out.println(enrollStudent.getProfile() + " is not enrolled.");
        }
        else {
            int pivot = find(enrollStudent.getProfile());
            for(int i = pivot; i < size; i++) {
                enrollStudents[i] = enrollStudents[i+1];
            }
            enrollStudents[size] = null;
            size--;
            System.out.println(enrollStudent.getProfile() + " dropped.");
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
        if(this.enrollStudents[0] == null) {
            System.out.println("Enrollment is empty!");
        }
        else {
            System.out.println("** Enrollment **");
            for (int i = 0; i < size; i++) {
                if (this.enrollStudents[i] != null) {
                    System.out.println(enrollStudents[i].toString());
                }
            }
        }
    }

    public void printTuition(Roster roster){
        if(size == 0) {
            System.out.println("Student roster is empty!");
        }
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
    public void endSemester(Roster roster){
        for(int i = 0; i < size; i++){ //iterate through enrollment
            EnrollStudent es = enrollStudents[i];
            Student s = roster.getStudent(es.getProfile());
            s.setCreditCompleted(s.getCreditCompleted() + es.getCreditsEnrolled());
        }
        System.out.println("Credit completed has been updated.");
        roster.printEligibleGraduates();
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
