package main.java.com.xscode;

import java.util.Scanner;

public class LoginForm {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";
    
    public void displayLogin() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n🔐 Login Form");
        
        System.out.println("==============");
        
        System.out.print("Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        if (authenticate(username, password)) {
            System.out.println("✅ Login successful! Welcome, " + username);
        } else {
            System.out.println("❌ Invalid username or password!");
        }
    }
    
    private boolean authenticate(String username, String password) {
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}