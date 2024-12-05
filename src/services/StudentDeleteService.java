package services;

import models.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDeleteService {
    public void deleteStudent(ArrayList<Student> students, Scanner sc) {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            if (id <= 0) {
                System.out.println("Invalid Student ID! Please enter a positive ID greater than 0.");
                return;
            }

            Student student = findStudentById(students, id);
            if (student != null) {
                System.out.println("Student found: " + student);
                System.out.print("Are you sure you want to delete this student? (yes/no): ");
                String confirmation = sc.next();
                if (confirmation.equalsIgnoreCase("yes")) {
                    students.remove(student);
                    System.out.println("Student with ID " + id + " has been removed.");
                } else {
                    System.out.println("Student deletion cancelled.");
                }
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid student ID.");
            sc.nextLine(); // Clear input buffer in case of invalid input
        }
    }

    private Student findStudentById(ArrayList<Student> students, int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }
}
