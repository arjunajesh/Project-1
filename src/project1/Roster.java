package project1;
/**
 * Class for Roster Object
 * @author Arjun Ajesh, Nathan Roh
 */

public class Roster {
    private Student[] roster;
    private int size;
    public static final int CAPACITY = 4;

    /**
     * Constructor for Roster Object
     */
    public Roster(){
        this.size = 0;
        this.roster = new Student[CAPACITY];
    }

    /**
     * Adds a student to the roster. If the roster is full, it will call grow()
     * @param student student that is to be added to roster
     * @return returns true if student was added, false if student is already in roster
     */
    public boolean add(Student student){
        if (size == roster.length){
            grow();
        }
        if(!contains(student)) {
            roster[size] = student;
            size++;
            return true;
        }
        else{
            System.out.println(student.getProfile().toString() + " is already in the roster.");
            return false;
        }
    }

    /**
     * Removes specified student from roster
     * @param student student to be removed
     * @return returns true if student is removed, false if student is not in roster
     */
    public boolean remove(Student student){
        if(find(student) == -1){ // student does not exist
            return false;
        }
        else{ // removing student
            int pivot = find(student);
            for(int i = pivot; i < size; i++){
                roster[i] = roster[i+1];
            }
            roster[size] = null;
            size--;
            return true;
        }
    }

    /**
     * Increases the roster size by 4
     */
    private void grow(){
        Student[] newRoster = new Student[size + CAPACITY];
        for(int i = 0; i < roster.length; i++){
            newRoster[i] = roster[i];
        }
        roster = newRoster;
    }

    /**
     * Finds the specified student in the roster
     * @param student
     * @return Integer index of student in index, -1 if student is not in roster
     */
    private int find(Student student){
        for (int i = 0; i < size; i++){
            if (student.equals(roster[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if student is in roster
     * @param student
     * @return true if student is in roster, false if not
     */
    public boolean contains(Student student){
        for(int i = 0; i < size; i++) {
            if(student.equals(roster[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * Changes the major of the student
     * @param student
     * @param major new major of the student
     * @return true is major was changed, false if invalid major or student does not exist in roster
     */
    public boolean change(Student student, String major){
        String majorL = major.toLowerCase();
        Major m;
        if (majorL.equals("bait")){
            m = Major.BAIT;
        }
        else if(majorL.equals("cs")){
            m = Major.CS;
        }
        else if(majorL.equals("math")){
            m = Major.MATH;
        }
        else if(majorL.equals("iti")){
            m = Major.ITI;
        }
        else if(majorL.equals("ee")){
            m = Major.EE;
        }
        else{
            System.out.println("Major code invalid: " + major);
            return false;
        }

        if(find(student) == -1){
            System.out.println(student.getProfile().toString() + " is not in the roster.");
            return false;
        }
        else{
            int pivot = find(student);
            roster[pivot].setMajor(m);
        }
        return true;
    }

    /**
     * Sorts the roster by last name, first name, and date of birth
     */
    public void sort(){
        if (size == 0){
            System.out.println("Student roster is empty!");
        }
        else {
            for (int i = 0; i < size - 1; i++) {
                for (int k = 0; k < size - i - 1; k++) {
                    if (roster[k].compareTo(roster[k + 1]) > 0) {
                        Student temp = roster[k];
                        roster[k] = roster[k + 1];
                        roster[k + 1] = temp;
                    }
                }
            }
        }
   }

    /**
     * Prints out the roster sorted by last name, first name, date of birth
     */
   public void sortByProfile(){
        if(size == 0){
            System.out.println("Student roster is empty!");
        }
        else{
            System.out.println("* Student roster sorted by last name, first name, DOB **");
            sort();
            printRoster();
            System.out.println("* end of roster **");
        }
   }

    /**
     * Prints out the roster sorted by standing
     */
   public void sortByStanding() {
       if (size == 0) {
           System.out.println("Student roster is empty!");
       } else {
           sort();
           System.out.println("* Student roster sorted by standing **");
           for (int i = 0; i < size; i++) {
               if (roster[i].getStanding().equals("Freshman")) {
                   System.out.println(roster[i].toString());
               }
           }
           for (int i = 0; i < size; i++) {
               if (roster[i].getStanding().equals("Junior")) {
                   System.out.println(roster[i].toString());
               }
           }
           for (int i = 0; i < size; i++) {
               if (roster[i].getStanding().equals("Senior")) {
                   System.out.println(roster[i].toString());
               }
           }
           for (int i = 0; i < size; i++) {
               if (roster[i].getStanding().equals("Sophomore")) {
                   System.out.println(roster[i].toString());
               }
           }
           System.out.println("* end of roster **");
       }
   }

    /**
     * Prints out the roster sorted by school, major
     */
   public void sortBySchoolMajor(){
       if (size == 0) {
           System.out.println("Student roster is empty!");
       } else {
           sort();
           System.out.println("* Student roster sorted by school, major **");
           for(int i = 0; i < size; i++){
               if(roster[i].getMajor().getMajorName().equals("BAIT")){
                   System.out.println(roster[i].toString());
               }
           }
           for(int i = 0; i < size; i++){
               if(roster[i].getMajor().getMajorName().equals("CS")){
                   System.out.println(roster[i].toString());
               }
           }
           for(int i = 0; i < size; i++){
               if(roster[i].getMajor().getMajorName().equals("MATH")){
                   System.out.println(roster[i].toString());
               }
           }
           for(int i = 0; i < size; i++){
               if(roster[i].getMajor().getMajorName().equals("SC&I")){
                   System.out.println(roster[i].toString());
               }
           }
           for(int i = 0; i < size; i++){
               if(roster[i].getMajor().getMajorName().equals("ITI")){
                   System.out.println(roster[i].toString());
               }
           }
           for(int i = 0; i < size; i++){
               if(roster[i].getMajor().getMajorName().equals("EE")){
                   System.out.println(roster[i].toString());
               }
           }
           System.out.println("* end of roster **");
       }
   }

    /**
     * Prints the roster
     */
    public void printRoster(){
        for(int i = 0; i < size; i++){
            if(this.roster[i] != null) {
                System.out.println(roster[i].toString());
            }
        }
    }

    /**
     * Prints the students in a specified school
     * @param school
     */
    public void printSchool(String school){
        if(!("RBS".equalsIgnoreCase(school)) &&
           !("SAS".equalsIgnoreCase(school)) &&
           !("SC&I".equalsIgnoreCase(school)) &&
           !("SOE".equalsIgnoreCase(school))){
            System.out.println("School doesn't exist: " + school);
            System.out.println("* Students in " + school + " *");
            System.out.println("* end of list **");
        }
        if(this.roster[0] == null){
            System.out.println("Student roster is empty!");
        }
        System.out.println("* Students in " + school + " *");
        for(int i = 0; i < size; i++){
            if((this.roster[i].getSchool()).equalsIgnoreCase(school) && (this.roster[i] != null)){
                System.out.println(this.roster[i].toString());
            }
        }
        System.out.println("* end of list **");
    }
}
