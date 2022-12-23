import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Class HRAssistant hold the main method to excute propram.
 * 
 * @author Hongbo Zhou
 */
public class HRAssistant {

    /**
     * Main method to excute the program
     * @param args command line arguments
     */
    public static void main(String[] args) {

        AssistantSystem assistantSystem = new AssistantSystem(args);
        if (assistantSystem.getRole().equals("audit")) {
            assistantSystem.loadFiles();
            assistantSystem.auditOperate();
        } else {
            displayWelcomeMessage(assistantSystem.getRole());
            assistantSystem.loadFiles();

            assistantSystem.displayMenuMessage();
            displayWaitingCommand();
            Scanner stdin = new Scanner(System.in);
            String command = stdin.nextLine();

            while (!command.equals("quit") && !command.equals("q")) {
                assistantSystem.operate(command, stdin);

                displayWaitingCommand();
                command = stdin.nextLine();
            }

            stdin.close();
            System.out.println();

        }

    }

    /**
     * Class constructor
     */
    public HRAssistant(){

    }

    /**
     * Display the Welcome Messages based on different role.
     * @param role the user role
     */
    private static void displayWelcomeMessage(String role) {

        Scanner inputStream = null;
        String filename;
        if (role.equals("applicant")) {
            filename = "welcome_applicant.ascii";
        } else {
            filename = "welcome_hr.ascii";
        }

        try {
            inputStream = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Welcome File not found.");
        }

        while (inputStream.hasNextLine()) {
            System.out.println(inputStream.nextLine());
        }

    }

    /**
     * Print waiting command arrow
     */
    private static void displayWaitingCommand() {
        System.out.print("> ");
    }

}
