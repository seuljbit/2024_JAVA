package student;

import java.util.Scanner;

public interface StudentProgram {
	void insertStudent(Scanner scan);
	void printStudent();
	Students searchStudent(Scanner scan);
	void modifyStudent(Scanner scan);
	void deleteStudent(Scanner scan);
}
