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
            String[] command = input.nextLine().split(" "); // splits by single space, need to change it to so that it splits by white space

            if (command[0].equals("A")){
                if(addStudent(command[1], command[2], command[3], command[4], Integer.parseInt(command[5]))){
                    System.out.println(command[1] + " " + command[2] + " " + command[3] + " added to the roster.");
                };
            }
            else if (command[0].equals("R")){
                Date date = new Date(command[3]);
                if(roster.remove(new Student(command[1], command[2], date))){
                    System.out.println(command[1] + " " + command[2] + " removed from roster.");
                }
                else{
                    System.out.println("Student does not exist.");
                }
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
        Date d = new Date(dob);
        if (!d.isValid()){
            System.out.println("DOB invalid: " + dob + " not a valid calendar date");
            return false;
        }
        return roster.add(new Student(fname, lname, d, major, credits));
    }

}
