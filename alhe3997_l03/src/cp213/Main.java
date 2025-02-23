package cp213;

import java.time.LocalDate;

/**
 * Tests the Student class.
 *
 * @author Mehdi Al-heloo, 169063997, alhe3997@mylaurier.ca
 * @version 2022-02-07
 */
public class Main {

    public static void main(String[] args) {
	final String line = "-".repeat(40);
	int id = 123456;
	String surname = "Brown";
	String forename = "David";
	LocalDate birthDate = LocalDate.parse("1962-10-25");
	Student student = new Student(id, surname, forename, birthDate);
	System.out.println("New Student:");
	System.out.println(student);
	System.out.println(line);

	System.out.println("Test Getters");
	// call getters here
	System.out.println("ID: " + student.getId());
	System.out.println("Surname: " + student.getSurname());
	System.out.println("Forename: " + student.getForename());
	System.out.println("Birthdate: " + student.getBirthDate());
	System.out.println(line);

	System.out.println("Test Setters");
	// call setters here
	student.setId(654321);
	student.setSurname("Smith");
	student.setForename("John");
	student.setBirthDate(LocalDate.parse("1990-12-15"));
	System.out.println("Updated Student:");
	System.out.println(student);
	System.out.println(line);

	System.out.println("Test compareTo");
	// create new Students - call comparisons here
	Student anotherStudent = new Student(111111, "Brown", "David", LocalDate.parse("1962-10-25"));
	if (student.compareTo(anotherStudent) > 0) {
	    System.out.println(student.getSurname() + " comes after " + anotherStudent.getSurname());
	} else if (student.compareTo(anotherStudent) < 0) {
	    System.out.println(student.getSurname() + " comes before " + anotherStudent.getSurname());
	} else {
	    System.out.println(student.getSurname() + " is the same as " + anotherStudent.getSurname());
	}
    }

}