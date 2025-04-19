// Student.java


package com.studentdata;

/**
 * Student entity class.
 */

public class Student {
    private String prn;
    private String name;
    private String dob;
    private double marks;

    public Student(String prn, String name, String dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    public String getPrn() { return prn; }
    public String getName() { return name; }
    public String getDob() { return dob; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setDob(String dob) { this.dob = dob; }
    public void setMarks(double marks) { this.marks = marks; }

    public void updateFrom(Student other) {
        this.name = other.name;
        this.dob = other.dob;
        this.marks = other.marks;
    }

    @Override
    public String toString() {
        return String.format("PRN: %s | Name: %-15s | DOB: %s | Marks: %.2f",
                prn, name, dob, marks);
    }
}
