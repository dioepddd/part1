package models;

public class Student {
    private int studentId;
    private String name;
    private double marks;

    // Constructor
    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters (Encapsulation)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        // Encapsulate validation to ensure marks are within range
        if (marks < 0 || marks > 10) {
            throw new IllegalArgumentException("Marks must be between 0 and 10.");
        }
        this.marks = marks;
    }

    // Determine rank based on marks (encapsulate logic)
    public String getRanking() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    // Display student details
    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Marks: " + marks + ", Rank: " + getRanking();
    }
}
