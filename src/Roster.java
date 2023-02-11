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
        if(find(student) == 0) {
            roster[size] = student;
            size++;
        }
        return true;
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
                return 1;
            }
        }
        return 0;
    }
}
