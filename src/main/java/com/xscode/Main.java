package main.java.com.xscode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🎓 Welcome to Garg library 🎓");
        System.out.println("==========================================");
        
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. View Student Profile");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    LoginForm loginForm = new LoginForm();
                    loginForm.displayLogin();
                    break;
                case 2:
                    Registration registration = new Registration();
                    registration.registerUser();
                    break;
                case 3:
                    StudentProfile profile = new StudentProfile();
                    profile.displayProfile();
                    break;
                case 4:
                    System.out.println("Thank you for using Student Management System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}