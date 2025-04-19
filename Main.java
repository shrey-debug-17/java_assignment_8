//Main.java

/*
Name: Shrey Ardeshana
PRN: 23070126019
Batch: AIML A1
*/

package com.studentdata;

import com.studentdata.exceptions.*;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static StudentManager manager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Data Entry System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> displayAll();
                    case 3 -> searchStudent();
                    case 4 -> updateStudent();
                    case 5 -> deleteStudent();
                    case 6 -> System.exit(0);
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addStudent() {
        try {
            System.out.print("Enter PRN: ");
            String prn = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter DOB (DD/MM/YYYY): ");
            String dob = scanner.nextLine();
            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();

            Student student = new Student(prn, name, dob, marks);
            manager.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private static void displayAll() {
        try {
            List<Student> students = manager.getAllStudents();
            System.out.println("\nAll Students:");
            students.forEach(System.out::println);
        } catch (DatabaseEmptyException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchStudent() {
        System.out.println("\nSearch by:");
        System.out.println("1. PRN");
        System.out.println("2. Name");
        System.out.println("3. Position");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter PRN: ");
                    Student s = manager.searchByPrn(scanner.nextLine());
                    System.out.println("Found: " + s);
                }
                case 2 -> {
                    System.out.print("Enter Name: ");
                    manager.searchByName(scanner.nextLine())
                            .forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter Position: ");
                    Student s = manager.searchByPosition(scanner.nextInt());
                    System.out.println("Found: " + s);
                    scanner.nextLine();
                }
                default -> System.out.println("Invalid search choice");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateStudent() {
        try {
            System.out.print("Enter PRN of student to update: ");
            String oldPrn = scanner.nextLine();

            System.out.println("Enter new details:");
            System.out.print("PRN: ");
            String prn = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("DOB: ");
            String dob = scanner.nextLine();
            System.out.print("Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();

            Student newData = new Student(prn, name, dob, marks);
            manager.updateStudent(oldPrn, newData);
            System.out.println("Update successful!");
        } catch (Exception e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        try {
            System.out.print("Enter PRN to delete: ");
            manager.deleteStudent(scanner.nextLine());
            System.out.println("Deletion successful!");
        } catch (Exception e) {
            System.out.println("Deletion failed: " + e.getMessage());
        }
    }
}
