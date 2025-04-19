//README.md


Student Data Entry System
A Java application to manage student records with robust validation and custom exception handling.
This project is structured for clarity, modularity, and extensibility, and follows Java best practices.

Table of Contents:

- Features
- Project Structure
- Class & Exception Descriptions
- Usage Instructions
- Exception Handling
- How to Run
- Commit History
- Author

Features
- Add new student records (with PRN, Name, DOB, Marks)
- Display all students
- Search students by:
	- PRN
	- Name
	- Position (index)
- Update edit student details
- Delete student records
- Comprehensive input validation
- Custom exceptions for robust error handling

Project Structure

src/
└── main/
    └── java/
        └── com/
            └── studentdata/
                ├── Main.java
                ├── Student.java
                ├── StudentManager.java
                └── exceptions/
                    ├── DatabaseEmptyException.java
                    ├── DuplicatePRNException.java
                    ├── InvalidDOBException.java
                    ├── InvalidPositionException.java
                    └── StudentNotFoundException.java

Class & Exception Descriptions:

Main Classes

- Main.java
	Entry point of the application. Provides a menu-driven CLI for all 	operations.

- Student.java
	Represents a student with PRN, Name, DOB, and Marks.
	Includes constructors, getters, setters, and an updateFrom() method.

- StudentManager.java
	Handles all business logic:

	- Adding, displaying, searching, updating, and deleting students

	- Input validation

	- Throws custom exceptions for error scenarios

Custom Exceptions:
- DatabaseEmptyException
	- Thrown when an operation is attempted on an empty student list.

- DuplicatePRNException
	- Thrown when adding a student with a PRN that already exists.

- InvalidDOBException
	- Thrown when the date of birth format is invalid.

- InvalidPositionException
	- Thrown when accessing a student at an invalid index.

- StudentNotFoundException
	- Thrown when a student cannot be found by PRN or name.

Usage Instructions:

1. Add Student
	Enter PRN, Name, DOB (DD/MM/YYYY), and Marks.
	The system checks for duplicate PRN and valid DOB format.

2. Display All
	Lists all students in the database.

3. Search Student
	- By PRN: Enter PRN to search.
	- By Name: Enter name (case-insensitive).
	- By Position: Enter the index (starting from 0).

4. Update Student
	- Enter the PRN of the student to update.
	- Enter new details (PRN, Name, DOB, Marks).

5. Delete Student
	- Enter PRN to delete the student record.

Exception Handling:

Each operation uses at least two custom exceptions for robust validation and error reporting:

- Add Student:

	DuplicatePRNException: Prevents duplicate PRN entries

	InvalidDOBException: Ensures DOB format is correct

- Display/Search/Update/Delete:

	DatabaseEmptyException: Prevents operations on empty database

	StudentNotFoundException / InvalidPositionException: Handles 	search/update/delete errors

How to Run:

1. Clone the repository:

	git clone https://github.com/<your-username>/Student-Data-Entry.git
	cd Student-Data-Entry

2. Compile the project :

	javac -d bin src/main/java/com/studentdata/*.java 	src/main/java/com/studentdata/exceptions/*.java

3. Run the application:

	java -cp bin com.studentdata.Main

Commit History

Each file and major function was committed separately for clarity and traceability.
See the GitHub commit history for details.

Author:

- Name: Shrey Ardeshana
- PRN: 23070126019
- Batch: AIML A1
- Location: Pune, Maharashtra, India

Repository Link:
https://github.com/shrey-debug-17/java_assignment_8