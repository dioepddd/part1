/*
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
*/
package services;

import models.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentSearchService {

    private StudentSortService studentSortService;

    public StudentSearchService() {
        studentSortService = new StudentSortService(); // Tạo một đối tượng của StudentSortService
    }

    public void searchStudent(ArrayList<Student> students, Scanner sc) {
        try {
            // Sử dụng StudentSortService để sắp xếp sinh viên trước khi tìm kiếm
            studentSortService.sortStudents(students);

            System.out.print("Enter Student ID to search: ");
            int id = sc.nextInt();
            Student student = binarySearch(students, id);

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

    // Phương thức tìm kiếm nhị phân (Binary Search) theo ID sinh viên
    private Student binarySearch(ArrayList<Student> students, int id) {
        int left = 0;
        int right = students.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Student midStudent = students.get(mid);

            // Nếu ID của sinh viên giữa mảng bằng ID cần tìm
            if (midStudent.getStudentId() == id) {
                return midStudent;
            }

            // Nếu ID cần tìm nhỏ hơn ID của sinh viên giữa mảng
            if (midStudent.getStudentId() > id) {
                right = mid - 1;
            }
            // Nếu ID cần tìm lớn hơn ID của sinh viên giữa mảng
            else {
                left = mid + 1;
            }
        }

        // Nếu không tìm thấy sinh viên
        return null;
    }
}
