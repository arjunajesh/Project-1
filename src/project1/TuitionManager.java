package project1; /**
 * Class for RosterManager Object
 * @author Arjun Ajesh, Nathan Roh
 */
import java.util.Scanner;

public class TuitionManager {
    static Roster roster;
    static Enrollment enrollment;

    public TuitionManager(){
        this.roster = new Roster();
        this.enrollment = new Enrollment();
    }

    public static void run(){
        System.out.println("Tuition Manager running...");
        boolean running = true;
        Scanner input = new Scanner(System.in);
        while(running){
            String[] command = input.nextLine().split(" +"); // splits by single space, need to change it to so that it splits by white space
            if(command[0].equals("Q")){
                System.out.println("Tuition Manager terminated.");
                running = false;
            }
            else{
                handleCommand(command);
            }
        }
        input.close();
    }

    /**
     * Takes the command and processes which command is being called
     * @param command String array, where first value will be the command, and the rest will be the parameters for the command
     */
    public static void handleCommand(String[] command){
        switch(command[0]){
            case "AR", "AN", "AT", "AI": addStudent(command);
                break;
            case "R": //roster.remove(new Student(command[1], command[2], new Date(command[3])));
                break;
            case "P": roster.sortByProfile();
                break;
            case "PS": roster.sortByStanding();
                break;
            case "PC": roster.sortBySchoolMajor();
                break;
            case "L": roster.printSchool(command[1]);
                break;
            case "C": //roster.change(new Student(command[1], command[2], new Date(command[3])), command[4]);
                break;
            case "":
                break;
            default: System.out.println(command[0] + " is an invalid command");
        }
    }

    public static boolean addStudent(String[] command){
        try{
            Major m = validateBasicCredentials(command[3], command[4], command[5]);
            if (m == null){
                return false;
            }
            switch(command[0]){
                case "AR": roster.add(new Resident(command[1], command[2], new Date(command[3]), m, Integer.parseInt(command[5])));
                break;
                case "AN": roster.add(new NonResident(command[1], command[2], new Date(command[3]), m, Integer.parseInt(command[5])));
                break;
                case "AT": roster.add(new TriState(command[1], command[2], new Date(command[3]), m, Integer.parseInt(command[5]), command[6]));
                break;
                case "AI":
                    boolean isStudyAbroad = command.length > 6 ? Boolean.parseBoolean(command[6]) : false;
                    roster.add(new International(command[1], command[2], new Date(command[3]), m, Integer.parseInt(command[5]), isStudyAbroad));
            }
            return true;
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Missing data in line command.");
            return false;
        }
    }

    public static Major validateBasicCredentials(String dob, String major, String credits){
        int c;
        try{ //Make sure credits is an integer
            c = Integer.parseInt(credits);
        }
        catch(NumberFormatException e){
            System.out.println("Credits completed invalid: not an integer!");
            return null;
        }
        if (c < 0) { //make sure credits is non-negative
            System.out.println("Credits completed invalid: cannot be negative!");
            return null;
        }
        Date d = new Date(dob);
        if (!d.isValid()) { //make sure date is a valid date
            return null;
        }
        Major m;
        switch(major.toLowerCase()){ // configure String major to appropriate major class
            case "bait": m = Major.BAIT;
                break;
            case "cs": m = Major.CS;
                break;
            case "math": m = Major.MATH;
                break;
            case "iti": m = Major.ITI;
                break;
            case "ee": m = Major.EE;
                break;
            default:
                System.out.println("Major code invalid: " + major);
                return null;
        }
        return m;
    }
}


