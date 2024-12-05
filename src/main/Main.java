package main;

import services.*;
import models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Thêm sẵn 5 sinh viên
        students.add(new Student(1, "Alice", 8.5));
        students.add(new Student(2, "Bob", 6.0));
        students.add(new Student(3, "Charlie", 9.3));
        students.add(new Student(4, "David", 7.8));
        students.add(new Student(5, "Eve", 9.0));




        StudentAddService addService = new StudentAddService();
        StudentEditService editService = new StudentEditService();
        StudentDeleteService deleteService = new StudentDeleteService();
        StudentViewService viewService = new StudentViewService();
        StudentSortService sortService = new StudentSortService();
        StudentSearchService searchService = new StudentSearchService();

        boolean running = true;


        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Students");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Search Student by ID");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addService.addStudent(students, sc);
                        break;
                    case 2:
                        editService.editStudent(students, sc);
                        break;
                    case 3:
                        deleteService.deleteStudent(students, sc);
                        break;
                    case 4:
                        viewService.viewStudents(students);
                        break;
                    case 5:
                        sortService.sortStudents(students);
                        break;
                    case 6:
                        searchService.searchStudent(students, sc);
                        break;
                    case 7:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); // Clear input buffer
            }
        }
        sc.close();
    }
}
