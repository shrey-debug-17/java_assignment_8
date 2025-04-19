//StudentManager.java

package com.studentdata;

import com.studentdata.exceptions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages student records and operations.
 */
public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) throws DuplicatePRNException, InvalidDOBException {
        validatePRN(student.getPrn());
        validateDOB(student.getDob());
        students.add(student);
    }

    public List<Student> getAllStudents() throws DatabaseEmptyException {
        if (students.isEmpty()) throw new DatabaseEmptyException("No students in database");
        return students;
    }

    public Student searchByPrn(String prn) throws StudentNotFoundException, DatabaseEmptyException {
        validateDatabase();
        return students.stream()
                .filter(s -> s.getPrn().equals(prn))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("PRN not found: " + prn));
    }

    public List<Student> searchByName(String name) throws StudentNotFoundException, DatabaseEmptyException {
        validateDatabase();
        List<Student> result = students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .toList();
        if (result.isEmpty()) throw new StudentNotFoundException("Name not found: " + name);
        return result;
    }

    public Student searchByPosition(int position) throws InvalidPositionException, DatabaseEmptyException {
        validateDatabase();
        if (position < 0 || position >= students.size()) {
            throw new InvalidPositionException("Invalid position: " + position);
        }
        return students.get(position);
    }

    public void updateStudent(String prn, Student newData)
            throws StudentNotFoundException, DuplicatePRNException, InvalidDOBException {
        Student student = searchByPrn(prn);
        if (!prn.equals(newData.getPrn())) validatePRN(newData.getPrn());
        validateDOB(newData.getDob());
        student.updateFrom(newData);
    }

    public void deleteStudent(String prn) throws StudentNotFoundException, DatabaseEmptyException {
        Student student = searchByPrn(prn);
        students.remove(student);
    }

    private void validatePRN(String prn) throws DuplicatePRNException {
        if (students.stream().anyMatch(s -> s.getPrn().equals(prn))) {
            throw new DuplicatePRNException("Duplicate PRN: " + prn);
        }
    }

    private void validateDOB(String dob) throws InvalidDOBException {
        if (!dob.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$")) {
            throw new InvalidDOBException("Invalid DOB format: " + dob);
        }
    }

    private void validateDatabase() throws DatabaseEmptyException {
        if (students.isEmpty()) throw new DatabaseEmptyException("Database is empty");
    }
}
