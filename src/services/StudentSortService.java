/*
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
                    // Hoán đổi\
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
*/
package services;

import models.Student;
import java.util.ArrayList;

public class StudentSortService {

    public void sortStudents(ArrayList<Student> students) {
        mergeSort(students, 0, students.size() - 1);
        System.out.println("Students sorted by marks using MergeSort!");
    }

    // Hàm MergeSort chính
    private void mergeSort(ArrayList<Student> students, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sắp xếp nửa bên trái và nửa bên phải
            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);

            // Gộp các phần đã sắp xếp
            merge(students, left, mid, right);
        }
    }

    // Hàm gộp các mảng đã sắp xếp
    private void merge(ArrayList<Student> students, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Tạo các mảng con tạm thời
        ArrayList<Student> leftList = new ArrayList<>(n1);
        ArrayList<Student> rightList = new ArrayList<>(n2);
        // Sao chép dữ liệu vào các danh sách con
        for (int i = 0; i < n1; i++) {
            leftList.add(students.get(left + i));
        }
        for (int i = 0; i < n2; i++) {
            rightList.add(students.get(mid + 1 + i));
        }
        // Gộp lại các mảng con vào danh sách ban đầu
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i).getMarks() <= rightList.get(j).getMarks()) {
                students.set(k, leftList.get(i));
                i++;
            } else {
                students.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại nếu có
        while (i < n1) {
            students.set(k, leftList.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            students.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}

