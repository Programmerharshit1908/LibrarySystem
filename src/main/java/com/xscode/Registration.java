package main.java.com.xscode;

import java.util.Scanner;

public class Registration {
    
    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n📝 Registration Form");
        System.out.println("===================");
        
        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        
        System.out.println("\n✅ Registration Details:");
        System.out.println("Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        System.out.println("Phone: " + phone);
        
        System.out.println("\n🎉 Registration completed successfully!");
    }
}