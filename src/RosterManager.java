import java.util.Scanner;

public class RosterManager {
    public static void run(){
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter command:");
            String[] command = input.nextLine().split(" ");
            if (command[0].equals("A")){
                System.out.println("Adding a new student");
            }
            else if (command[0].equals("R")){
                System.out.println("Removing student");
            }
            else if (command[0].equals("P")){
                System.out.println("Display the roster sorted by last name, first name, and DOB");
            }
        }
    }
}
