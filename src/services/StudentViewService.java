package services;

import models.Student;
import java.util.ArrayList;

public class StudentViewService {
    public void viewStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
