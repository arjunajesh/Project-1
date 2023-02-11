public class Roster {
    private Student[] roster;
    private int size;
    public Roster(){
        this.size = 0;
        this.roster = new Student[4];
    }
    public boolean add(Student student){
        if (size == roster.length){
            System.out.println("roster max size reached");
            grow();
        }
        if(find(student) == -1) {
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
}
