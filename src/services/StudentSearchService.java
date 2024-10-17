package services;

import models.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentSearchService {
    public void searchStudent(ArrayList<Student> students, Scanner sc) {
        try {
            System.out.print("Enter Student ID to search: ");
            int id = sc.nextInt();

            Student student = findStudentById(students, id);
            if (student != null) {
                System.out.println(student);
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
