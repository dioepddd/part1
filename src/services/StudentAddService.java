package services;

import models.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentAddService {
    public void addStudent(ArrayList<Student> students, Scanner sc) {
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            // Check if ID is duplicated
            if (isIdDuplicate(students, id)) {
                System.out.println("ID already exists! Please enter a unique ID.");
                return;
            }
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            // Validate that the name is not empty
            if (name.trim().isEmpty()) {
                System.out.println("Invalid input! Name cannot be empty.");
                return;
            }
            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();
            // Validate marks range
            if (marks < 0 || marks > 10) {
                System.out.println("Invalid input! Marks should be between 0 and 10.");
                return;
            }
            // Create and add student
            Student student = new Student(id, name, marks);
            students.add(student);
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter the correct data type.");
            sc.nextLine(); // Clear input buffer
        }
    }

    private boolean isIdDuplicate(ArrayList<Student> students, int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return true; // ID đã tồn tại
            }
        }
        return false; // ID không trùng lặp
    }
}
