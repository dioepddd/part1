package services;

import models.Student;
import java.util.ArrayList;

public class StudentSortService {
    public void sortStudents(ArrayList<Student> students) {
        int n = students.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    // Hoán đổi
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true; // Đánh dấu rằng có hoán đổi xảy ra
                }
            }
            // Nếu không có hoán đổi nào xảy ra, danh sách đã được sắp xếp
            if (!swapped) {
                break;
            }
        }
        System.out.println("Students sorted by marks using Bubble Sort!");
    }
}
