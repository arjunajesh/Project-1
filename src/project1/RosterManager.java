package project1; /**
 * Class for RosterManager Object
 * @author Arjun Ajesh, Nathan Roh
 */
import java.util.Scanner;

public class RosterManager {
    static Roster roster;

    public RosterManager(){
        this.roster = new Roster();
    }

    public static void run(){
        System.out.println("Roster Manager running...");
        boolean running = true;
        Scanner input = new Scanner(System.in);
        while(running){
            String[] command = input.nextLine().split(" +"); // splits by single space, need to change it to so that it splits by white space
            if(command[0].equals("Q")){
                System.out.println("Roster Manager terminated.");
                running = false;
            }
            else{
                handleCommand(command);
            }
        }
        input.close();
    }

    /**
     * Generates and adds new student given that valid credits, DOB, and major are specified
     * @param fname first name of student
     * @param lname last name of student
     * @param dob date of birth of student
     * @param major major of student
     * @param credits credits student has earned
     * @return true or false depending on whether the student was succesfully added
     */
    private static boolean addStudent(String fname, String lname, String dob, String major, int credits) {
        if (credits < 0) {
            System.out.println("Credits completed invalid: cannot be negative!");
            return false;
        }
        Date d = new Date(dob);
        if (!d.isValid()) {
            return false;
        }

        String majorL = major.toLowerCase();
        Major m;
        if (majorL.equals("bait")) {
            m = Major.BAIT;
        } else if (majorL.equals("cs")) {
            m = Major.CS;
        } else if (majorL.equals("math")) {
            m = Major.MATH;
        } else if (majorL.equals("iti")) {
            m = Major.ITI;
        } else if (majorL.equals("ee")) {
            m = Major.EE;
        } else {
            System.out.println("Major code invalid: " + major);
            return false;
        }
        return roster.add(new Student(fname, lname, d, m, credits));
    }

    /**
     * Changes student's major
     * @param student student whose major to change
     * @param major student's new major
     * @return true or false depending on whether student's major was successfully changed
     */
    private static boolean changeMajor(Student student, String major){
       return roster.change(student, major);
    }

    /**
     * Takes the command and processes which command is being called
     * @param command String array, where first value will be the command, and the rest will be the parameters for the command
     */
    public static void handleCommand(String[] command){
        if (command[0].equals("A")){
            try{
                Integer.parseInt(command[5]);
                if(addStudent(command[1], command[2], command[3], command[4], Integer.parseInt(command[5]))){
                    System.out.println(command[1] + " " + command[2] + " " + command[3] + " added to the roster.");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Credits completed invalid: not an integer!");
            }
        }
        else if (command[0].equals("R")){
            Date date = new Date(command[3]);
            if(roster.remove(new Student(command[1], command[2], date))) System.out.println(command[1] + " " + command[2] + " " + date + " removed from the roster.");
            else System.out.println(command[1] + " " + command[2] + " " + date + " is not in the roster.");
        }
        else if(command[0].equals("P")){
            roster.sortByProfile();
        }
        else if(command[0].equals("PS")) {
            roster.sortByStanding();
        }
        else if(command[0].equals("PC")){
            roster.sortBySchoolMajor();
        }
        else if(command[0].equals("L")){
            roster.sort();
            roster.printSchool(command[1]);
        }
        else if (command[0].equals("C")) {
            if (changeMajor((new Student(command[1], command[2], new Date(command[3]))), command[4])) System.out.println(command[1] + " " + command[2] + " " + command[3] + " major changed to " + command[4]);
        }
        else if (command[0].isBlank()){
        }
        else{
            System.out.println(command[0] + " is an invalid command!");
        }
    }
}