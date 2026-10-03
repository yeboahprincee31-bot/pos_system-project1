import java.util.Scanner;

public class Login {

    public static boolean login(Scanner input) {

        String correctUsername = "admin";
        String correctPassword = "1234";

        int attempts = 0;

        while (attempts < 3) {

            System.out.println("\n===== POS LOGIN =====");

            System.out.print("Username: ");
            String username = input.nextLine();

            System.out.print("Password: ");
            String password = input.nextLine();

            if (username.equals(correctUsername) &&
                    password.equals(correctPassword)) {

                System.out.println("\nLogin successful!");
                return true;

            } else {

                attempts++;

                System.out.println("\nInvalid username or password.");
                System.out.println("Attempts remaining: " + (3 - attempts));
            }
        }

        System.out.println("\nToo many failed attempts.");
        System.out.println("System locked.");

        return false;
    }
}