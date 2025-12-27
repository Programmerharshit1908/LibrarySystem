package main.java.com.xscode;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.*;

public class DatabaseConnector {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "libraryDB";
    private static final String STUDENTS_COLLECTION = "students";
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> studentsCollection;
    
    public DatabaseConnector() {
        try {
            // Connect to MongoDB
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            studentsCollection = database.getCollection(STUDENTS_COLLECTION);
            
            System.out.println("✅ Connected to MongoDB successfully!");
        } catch (Exception e) {
            System.out.println("❌ MongoDB Connection Error: " + e.getMessage());
        }
    }
    
    // Register a new student
    public boolean registerStudent(String fullName, String email, String phone, 
                                   String course, String year, String password) {
        try {
            // Check if email already exists
            Document existingStudent = studentsCollection.find(Filters.eq("email", email)).first();
            if (existingStudent != null) {
                System.out.println("❌ Email already registered!");
                return false;
            }
            
            // Generate student ID
            String studentId = "LIB" + (1000 + new Random().nextInt(9000));
            
            // Create student document
            Document studentDoc = new Document()
                .append("studentId", studentId)
                .append("fullName", fullName)
                .append("email", email)
                .append("phone", phone)
                .append("course", course)
                .append("year", year)
                .append("password", password)
                .append("registrationDate", new Date())
                .append("borrowedBooks", new ArrayList<Document>());
            
            // Insert into database
            studentsCollection.insertOne(studentDoc);
            System.out.println("✅ Student registered successfully! ID: " + studentId);
            return true;
            
        } catch (Exception e) {
            System.out.println("❌ Registration Error: " + e.getMessage());
            return false;
        }
    }
    
    // Login student
    public Document loginStudent(String email, String password) {
        try {
            Document student = studentsCollection.find(
                Filters.and(
                    Filters.eq("email", email),
                    Filters.eq("password", password)
                )
            ).first();
            
            if (student != null) {
                System.out.println("✅ Login successful for: " + student.getString("fullName"));
            } else {
                System.out.println("❌ Invalid email or password!");
            }
            
            return student;
            
        } catch (Exception e) {
            System.out.println("❌ Login Error: " + e.getMessage());
            return null;
        }
    }
    
    // Get student profile
    public Document getStudentProfile(String email) {
        try {
            return studentsCollection.find(Filters.eq("email", email)).first();
        } catch (Exception e) {
            System.out.println("❌ Profile Error: " + e.getMessage());
            return null;
        }
    }
    
    // Add borrowed book
    public boolean addBorrowedBook(String email, String bookTitle, String author, String dueDate) {
        try {
            // Create book document
            Document bookDoc = new Document()
                .append("title", bookTitle)
                .append("author", author)
                .append("dueDate", dueDate)
                .append("fine", 0);
            
            // Add to student's borrowed books array
            Bson update = Updates.push("borrowedBooks", bookDoc);
            studentsCollection.updateOne(Filters.eq("email", email), update);
            
            System.out.println("✅ Book added to borrowed list!");
            return true;
            
        } catch (Exception e) {
            System.out.println("❌ Add Book Error: " + e.getMessage());
            return false;
        }
    }
    
    // Close connection
    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("🔌 MongoDB connection closed.");
        }
    }
}