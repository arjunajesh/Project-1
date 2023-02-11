import java.util.Scanner;

public class RosterManager {
    static Roster roster;
    public RosterManager(){
        this.roster = new Roster();
    }
    public static void run(){
        System.out.println("Roster Manager running...");
        boolean running = true;

        while(running){

            Scanner input = new Scanner(System.in);
            String[] command = input.nextLine().split(" ");

            if (command[0].equals("A")){
                System.out.println("adding new student");
                addStudent(command[1], command[2], command[3], command[4], Integer.parseInt(command[5]));
            }
            else if (command[0].equals("Q")){
                System.out.println("Roster Manager terminated.");
                running = false;
            }
        }
    }
    private static boolean addStudent(String fname, String lname, String dob, String major, int credits){
        if(credits < 0){
            return false;
        }
        Date d = new Date(dob); //need to check if student is atleast 16, and if student already exists in the database
        if (!d.isValid()){
            return false;
        }
        System.out.println("Creating new student object and passing to roster");
        return roster.add(new Student(fname, lname, d, major, credits));
    }

}
