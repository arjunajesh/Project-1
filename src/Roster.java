public class Roster {
    private Student[] roster;
    private int size;
    public Roster(){
        this.size = 0;
        this.roster = new Student[4];
    }
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
            System.out.println("Student is already in roster");
            return false;
        }
    }

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
            return true;
        }
    }
    private void grow(){
        Student[] newRoster = new Student[size + 4];
        for(int i = 0; i < roster.length; i++){
            newRoster[i] = roster[i];
        }
        roster = newRoster;
    }
    private int find(Student student){
        for (int i = 0; i < size; i++){
            if (student.equals(roster[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Student student){
        for(int i = 0; i < size; i++) {
            if(student.equals(roster[i])){
                return true;
            }
        }
        return false;
    }

    public boolean change(Student student, String major){
        major = major.toLowerCase();
        Major m;
        if (major.equals("bait")){
            m = Major.BAIT;
        }
        else if(major.equals("cs")){
            m = Major.CS;
        }
        else if(major.equals("math")){
            m = Major.MATH;
        }
        else if(major.equals("iti")){
            m = Major.ITI;
        }
        else if(major.equals("ee")){
            m = Major.EE;
        }
        else{
            System.out.println("Major code invalid: " + major);
            return false;
        }

        if(find(student) == -1){
            return false;
        }
        else{
            int pivot = find(student);
            roster[pivot].setMajor(m);
        }
        return true;
    }
    public void sortByProfile(){
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
   public void sortByStanding() {
       if (size == 0) {
           System.out.println("Student roster is empty!");
       } else {
           sortByProfile();
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
       }
   }
   public void sortBySchoolMajor(){
       if (size == 0) {
           System.out.println("Student roster is empty!");
       } else {
           sortByProfile();

       }
   }
    public void printRoster(){
        if(this.roster[0] == null){
            System.out.println("Student roster is empty!");
        }
        for(int i = 0; i < size; i++){
            if(this.roster[i] != null) {
                System.out.println(roster[i].toString());
            }
        }
    }

    public void printSchool(String school){
        if(this.roster[0] == null){
            System.out.println("Student roster is empty!");
        }
        for(int i = 0; i < size; i++){
            if((this.roster[i].getSchool()).equalsIgnoreCase(school) && (this.roster[i] != null)){
                System.out.println(this.roster[i].toString());
            }
        }
    }
}
