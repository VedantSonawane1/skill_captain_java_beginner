import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    private static ArrayList<Map<String, String>> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the e-commerce application user registration!");

        while (true) {
            Map<String, String> userData = new HashMap<>();

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            userData.put("Name", name);

            System.out.print("Enter your email address: ");
            String email = scanner.nextLine();
            while (!isValidEmail(email)) {
                System.out.print("Invalid email address. Please enter a valid email address: ");
                email = scanner.nextLine();
            }
            userData.put("Email", email);

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            userData.put("Password", password);

            System.out.print("Enter your shipping address: ");
            String shippingAddress = scanner.nextLine();
            userData.put("Shipping Address", shippingAddress);

            users.add(userData);

            System.out.println("User registration successful!");
            System.out.print("Do you want to register another user? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Registered Users:");
        for (Map<String, String> user : users) {
            System.out.println("Name: " + user.get("Name"));
            System.out.println("Email: " + user.get("Email"));
            System.out.println("Password: " + user.get("Password"));
            System.out.println("Shipping Address: " + user.get("Shipping Address"));
            System.out.println();
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
