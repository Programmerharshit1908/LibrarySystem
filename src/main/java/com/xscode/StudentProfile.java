package main.java.com.xscode;

import java.util.Scanner;

public class StudentProfile {
    
    public void displayProfile() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n👨‍🎓 Student Profile");
        System.out.println("==================");
        
        // Sample student data
        String[] students = {
            "1. John Doe - Roll No: 101 - Grade: A",
            "2. Jane Smith - Roll No: 102 - Grade: A+",
            "3. Bob Johnson - Roll No: 103 - Grade: B",
            "4. Alice Brown - Roll No: 104 - Grade: A-"
        };
        
        System.out.println("Available Student Profiles:");
        for (String student : students) {
            System.out.println(student);
        }
        
        System.out.print("\nEnter roll number to view details (101-104): ");
        int rollNo = scanner.nextInt();
        
        switch (rollNo) {
            case 101:
                displayStudentDetails("John Doe", 101, "Computer Science", "A", "john@email.com");
                break;
            case 102:
                displayStudentDetails("Jane Smith", 102, "Mathematics", "A+", "jane@email.com");
                break;
            case 103:
                displayStudentDetails("Bob Johnson", 103, "Physics", "B", "bob@email.com");
                break;
            case 104:
                displayStudentDetails("Alice Brown", 104, "Chemistry", "A-", "alice@email.com");
                break;
            default:
                System.out.println("❌ Student not found!");
        }
    }
    
    private void displayStudentDetails(String name, int rollNo, String course, String grade, String email) {
        System.out.println("\n📋 Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
        System.out.println("Email: " + email);
        System.out.println("Status: Active");
    }
}