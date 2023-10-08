package edu.andrew.service;

import edu.andrew.model.Student;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public interface StudentService {
    boolean create(Student student);
    Set<Student> read();
    boolean update(int id, int newUserId, String newLastName, String newFirstName, String newMiddleName, String newBirthDate, String newPhoneNumber, String newFaculty, int newCourse, String newGroup);
    boolean delete(int id);
    Student getById(int id);
    Set<Student> getByFaculty(String faculty);
    Set<Student> getByBirthDate(String birthDate);
    Set<Student> getByGroup(String group);
    Set<Student> getByUserId(int userId);
}
