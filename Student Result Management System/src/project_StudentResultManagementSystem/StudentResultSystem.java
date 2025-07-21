package project_StudentResultManagementSystem;

import java.util.*;

public class StudentResultSystem {
    private Map<Integer, Student> studentMap;
    private Scanner sc;

    public StudentResultSystem() {
        studentMap = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> {
                    System.out.println("Exiting System...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student student = new Student(name, rollNo, marks);
        studentMap.put(rollNo, student);
        System.out.println("Student Added Successfully.\n");
    }

    private void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No student records found.\n");
            return;
        }

        System.out.println("---- Student Report ----");
        for (Student student : studentMap.values()) {
            student.displayStudentReport();
        }
    }
}
