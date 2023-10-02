package edu.andrew.service.impl;

import edu.andrew.dao.Dao;
import edu.andrew.model.Student;
import edu.andrew.model.User;
import edu.andrew.service.StudentService;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public class StudentServiceImpl implements StudentService {
    Dao studentDao;

    public StudentServiceImpl(Dao studentDao) {
        this.studentDao = studentDao;
    }
    
    @Override
    public boolean create(Student student) {
        return studentDao.create(student) > 0;
    }

    @Override
    public Set<Student> read() {
        return studentDao.read();
    }

    @Override
    public boolean update(int id, int newUserId, String newLastName, String newFirstName, String newMiddleName, String newBirthDate, String newPhoneNumber, String newFaculty, int newCourse, String newGroup) {
        Student student = new Student(id);
        student.setUserId(newUserId);
        student.setLastName(newLastName);
        student.setFirstName(newFirstName);
        student.setMiddleName(newMiddleName);
        student.setBirthDate(newBirthDate);
        student.setPhoneNumber(newPhoneNumber);
        student.setFaculty(newFaculty);
        student.setCourse(newCourse);
        student.setCourse(newCourse);
        student.setGroup(newGroup);
        return studentDao.update(student) > 0;
    }

    @Override
    public boolean delete(int id) {
        Student student = new Student(id);
        return studentDao.delete(student) > 0;
    }

    @Override
    public Student getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
