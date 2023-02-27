package project1; /**
 * Class for RosterManager Object
 * @author Arjun Ajesh, Nathan Roh
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
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
            case "E": addEnrollment(command);
                break;
            case "R": roster.remove(new Profile(command[1], command[2], new Date(command[3])));
                break;
            case "P": roster.sortByProfile();
                break;
            case "PS": roster.sortByStanding();
                break;
            case "PC": roster.sortBySchoolMajor();
                break;
            case "L": roster.printSchool(command[1]);
                break;
            case "C": roster.change(new Profile(command[1], command[2], new Date(command[3])), command[4]);
                break;
            case "D": enrollment.remove(new EnrollStudent(new Profile(command[1], command[2], new Date(command[3])), 0));
                break;
            case "PE": enrollment.printEnrollment();
                break;
            case "S": awardScholarship(command);
                break;
            case "PT": enrollment.printTuition(roster);
                break;
            case "LS": loadFile(command);
                break;
            case "SE": enrollment.endSemester(roster);
                break;
            default: System.out.println(command[0] + " is an invalid command");
        }
    }
    public static boolean awardScholarship(String[] command){
        try{
            Profile p = new Profile(command[1], command[2], new Date(command[3]));
            Student s = roster.getStudent(p);
            //first check if student is not in the roster
            if(s == null){
                System.out.println("Student not in the roster CHANGE LATER");
                return false;
            }
            //verify that student is a resident
            if(!s.isResident()){
                System.out.println(s.getProfile().toString() + "(" + getTypeString(s) + ")" + " is not eligible for the scholarship.");
                return false;
            }
            //verify student is not part-time
            if(!enrollment.getEnrolledStudent(s.getProfile()).isFulltime()){
                System.out.println(s.getProfile() + " part time student is not eligible for the scholarship.");
                return false;
            }
            //verify scholarship amount is valid
            int scholarshipAmount = Integer.parseInt(command[4]);
            if (scholarshipAmount <= 0 || scholarshipAmount > 10000){
                System.out.println(scholarshipAmount + ": invalid amount");
                return false;
            }
            //award scholarship
            Resident r = (Resident) s;
            r.setScholarship(scholarshipAmount);
            System.out.println(s.getProfile() + ": scholarship amount updated.");
            return true;
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Missing data in line command.");
            return false;
        }
        catch(NumberFormatException e){
            System.out.println("Amount is not an integer");
            return false;
        }
    }
    public static String getTypeString(Student s){
        if(s instanceof Resident){
            return "Resident";
        }
        else if(s instanceof International){
            return "International";
        }
        else if(s instanceof TriState){
            return "Tri-state";
        }
        else if(s instanceof NonResident){
            return "Non-resident";
        }
        else return "";
    }
    public static boolean addEnrollment(String[] command){
        try{
            Profile p = new Profile(command[1], command[2], new Date(command[3]));
            Student s = roster.getStudent(p);
            //first check if student is not in the roster
            if(s == null){
                System.out.println("Cannot enroll: " + s.toString() + " is not in the roster.");
                return false;
            }

            //check if number of credits is valid
            int numCredits = Integer.parseInt(command[4]);
            if(!s.isValid(numCredits)){
                System.out.println("(" + getTypeString(s) + ") " + numCredits + ": invalid credit hours.");
                return false;
            }

            //add to enrollment
            enrollment.add(new EnrollStudent(s.getProfile(), numCredits));
            System.out.println(s.getProfile() + " enrolled " + numCredits + " credits");
            return true;

        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Missing data in line command.");
            return false;
        }
        catch(NumberFormatException e){
            System.out.println("Credits not an integer CHANGE LATER");
            return false;
        }
        catch(Exception e){
            System.out.println("Error occurred "  + e.getMessage());
            return false;
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
        catch(Exception e){
            System.out.println("Error occurred "  + e.getMessage());
            return false;
        }
    }

    public static void loadFile(String[] command) {
        File file = new File(command[1]);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] token = str.split(",");
            Major m = validateBasicCredentials(token[3], token[4], token[5]);
            switch(token[0]){
                case "R": roster.add(new Resident(token[1], token[2], new Date(token[3]), m, Integer.parseInt(token[5])));
                break;
                case "N": roster.add(new NonResident(token[1], token[2], new Date(token[3]), m, Integer.parseInt(token[5])));
                break;
                case "T": roster.add(new TriState(token[1], token[2], new Date(token[3]), m, Integer.parseInt(token[5]), token[6]));
                break;
                case "I":
                    boolean isStudyAbroad = false;
                    if(token[6].equalsIgnoreCase("true")) {
                        isStudyAbroad = true;
                    }
                    roster.add(new International(token[1], token[2], new Date(token[3]), m, Integer.parseInt(token[5]), isStudyAbroad));
            }
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


