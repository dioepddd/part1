package services;

import models.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentEditService {
    public void editStudent(ArrayList<Student> students, Scanner sc) {
        try {
            System.out.print("Enter Student ID to edit: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            Student student = findStudentById(students, id);
            if (student != null) {
                System.out.println("Editing Student: " + student);
                System.out.print("Enter new Name (leave empty to keep current name): ");
                String newName = sc.nextLine();

                // Name validation
                if (!newName.trim().isEmpty()) {
                    student.setName(newName);
                }

                System.out.print("Enter new Marks (0-10): ");
                double newMarks = sc.nextDouble();

                // Marks validation
                if (newMarks < 0 || newMarks > 10) {
                    System.out.println("Invalid marks! Please enter a value between 0 and 10.");
                    return;
                }

                student.setMarks(newMarks);
                System.out.println("Student details updated successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter the correct data type.");
            sc.nextLine(); // Clear input buffer
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
