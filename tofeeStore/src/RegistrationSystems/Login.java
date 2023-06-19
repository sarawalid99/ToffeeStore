package RegistrationSystems;

import java.util.Scanner;
import java.util.regex.Pattern;

import SystemUsers.Customer;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Login class is used to check if the user's input is valid and if the user's
 * input is related to the data in the file.
 *
 * @version 1.0
 * @since 2021-09-30
 */
public class Login {
    private Customer user;

    /**
     * Constructor for Login class.
     *
     * @param user The user that is logging in.
     */
    public Login(Customer user) {
        this.user = user;
    }
    /**
     * Checks if the email is valid.
     *
     * @param email The email that is being checked.
     * @return True if the email is valid, false otherwise.
     */
    public boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("(\\w+)(\\.|_)?(\\w*)@(\\w+)(\\.(\\w+))+");
        return pattern.matcher(email).matches();
    }
    /**
     * Checks if the password is valid.
     *
     * @param password The password that is being checked.
     * @return True if the password is valid, false otherwise.
     */
    public boolean isValidPassword(String password) {
        // Checks if the password is at least 8 characters long and contains at least
        // one digit and one special character
        boolean hasDigit = false;
        boolean hasSpecial = false;
        if (password.length() < 8) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isWhitespace(c) || Character.isISOControl(c)) {
                return false;
            } else {
                hasSpecial = true;
            }
        }
        return hasDigit && hasSpecial;
    }
    /**
     * Checks if the user's input is related to the data in the file.
     *
     * @param email The email that is being checked.
     * @param password The password that is being checked.
     * @return True if the user's input is related to the data in the file, false otherwise.
     * @throws IOException
     */
    public boolean isRelated(String email, String password) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(email) && parts[1].equals(password)) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }
    /**
     * Checks if the user's input is valid and if the user's input is related to the data in the file.
     *
     * @return True if the user's input is valid and if the user's input is related to the data in the file, false otherwise.
     * @throws IOException
     */
    public boolean login() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Get user input
            System.out.print("Enter your Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            user.setEmail(email);
            user.setPassword(password);
            Login l1 = new Login(user);

            // Check if input is valid
            if (!l1.isValidEmail(email)) {
                System.out.println("Invalid email. Please enter a valid email address.");
                continue;
            }

            if (!l1.isValidPassword(password)) {
                System.out.println(
                        "Invalid password. Password must be at least 8 characters long and contain at least one digit and one special character.");
                continue;
            }
            if (l1.isRelated(email, password)) {
                System.out.println("Login Successfully!");
                return true;
            } else {
                System.out.println("Login Failed!");
                return false;
            }
        }
    }

}
