package RegistrationSystems;

import java.util.regex.Matcher;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import OrderDetails.Address;
import SystemUsers.GeneralUser;


/**
 * This class is responsible for the registration process of the user
 */
public class Registration {
    private GeneralUser user;

    public Registration(GeneralUser user){
        this.user = user;
    }

    /**
     * This method is responsible for the registration process
     * @return boolean
     */
    public static boolean isValidEmail(String email) {
        // Regular expression for email validation
        Pattern pattern = Pattern.compile("(\\w+)(\\.|_)?(\\w*)@(\\w+)(\\.(\\w+))+");
        return pattern.matcher(email).matches();
    }

    /**
     * This method is responsible for the registration process of the user and saving the data in the file
     * @return boolean
     */
    public static boolean isValidPassword(String password) {
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
                return false; // reject whitespace or control characters
            } else if (!Character.isLetter(c)) {
                hasSpecial = true;
            }
        }
        return hasDigit && hasSpecial;
    }
    /**
     * This method checks if the username is valid
     * @return boolean
     */
    public static boolean isValidUsername(String username) {
        // Checks if the username contains only alphanumeric characters
        return username.matches("[A-Za-z0-9]+");
    }
    /**
     * This method checks if the phone number is valid
     * @return boolean
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^(012|011|015)\\d{8}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    /**
     * This method checks if the email is already registered
     * @return boolean
     */
    public boolean isEmailRegistered(String email) throws Exception {

        List<String> lines = Files.readAllLines(Paths.get("users.txt"));
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts[0].equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is responsible for the registration process of the user and saving the data in the file
     * @throws Exception
     */
    public void SignUp() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String email, password, phoneNumber, username, government, district, buildingInfo, landMarker;

            // Get user input
            System.out.print("Enter your email: ");
            email = scanner.nextLine();

            System.out.print("Enter your password: ");
            password = scanner.nextLine();

            System.out.print("Enter your government: ");
            government = scanner.nextLine();

            System.out.print("Enter your district: ");
            district = scanner.nextLine();

            System.out.print("Enter your building info: ");
            buildingInfo = scanner.nextLine();

            System.out.print("Enter your land marker: ");
            landMarker = scanner.nextLine();

            System.out.print("Enter your phone number: ");
            phoneNumber = scanner.nextLine();

            System.out.print("Enter your username: ");
            username = scanner.nextLine();
            Address address = new Address(government, district, buildingInfo, landMarker);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNum(phoneNumber);

            // Check if input is valid
            if (!isValidEmail(user.getEmail())) {
                System.out.println("Invalid email. Please enter a valid email address.");
                continue;
            }

            if (!isValidPassword(user.getPassword())) {
                System.out.println("Invalid password. Password must be at least 8 characters long and " +
                        "contain at least one digit and one special character.");
                continue;
            }
            if (!isValidUsername(user.getUsername())) {
                System.out.println("Invalid username. Username must contain only alphanumeric characters.");
                continue;
            }
            if (!isValidPhoneNumber(user.getPhoneNum())) {
                System.out.println("Invalid phone. Enter a valid number.");
                continue;
            }

            if (isEmailRegistered(user.getEmail())) {
                System.out.println("Email already registered. Please enter a different email.");
                continue;
            }

            // Send OTP to user's email-------------
            SendOTP.sendOTP(user.getEmail());
            String checkOTP = SendOTP.getOTP();
            System.out.print("Enter the OTP sent to your email: ");
            String userOTP = scanner.nextLine();
            while(!checkOTP.equals(userOTP)){
                System.out.println("Invalid OTP. Please try again.");
                userOTP = scanner.nextLine();
            }
            //--------------------------------------
            String filename = "users.txt";
            FileWriter writer = new FileWriter(filename, true);
            writer.write(email + "," + password + "\n");
            writer.write(phoneNumber + "," + username + "," + government + "," + district + "," + buildingInfo + ","
                    + landMarker + "\n");
            writer.write("----------------------------------------------------------\n");
            writer.close();
            System.out.println("Registration successful");
            break;
        }

    }
}

