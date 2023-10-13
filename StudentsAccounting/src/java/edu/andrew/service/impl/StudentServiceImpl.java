package edu.andrew.service.impl;

import edu.andrew.dao.Dao;
import edu.andrew.model.Student;
import edu.andrew.model.User;
import edu.andrew.service.StudentService;
import java.util.Set;
import static java.util.stream.Collectors.toSet;

/**
 *
 * @author Andrew
 */
public class StudentServiceImpl implements StudentService {
    Dao<Student> studentDao;

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
        return studentDao.read().stream().filter(student -> id == student.getId())
                .collect(toSet()).iterator().next();
    }
    
    @Override
    public Set<Student> getByFaculty(String faculty) {
        return studentDao.read().stream().filter(student -> faculty.equals(student.getFaculty()))
                .collect(toSet());
    }
    
    @Override
    public Set<Student> getByBirthDate(String birthDate) {
//        Student student = new Student();
//        String[] splitBirthDate = student.getBirthDate().split("-");
//        String year = splitBirthDate[0];
//        String month = splitBirthDate[1];
//        String day = splitBirthDate[2];
            // Дата хранится в формате yy-mm-dd, поэтому использую первый элемент для фильтрации по году
        return studentDao.read().stream().filter(student -> Integer.parseInt(birthDate) <= Integer.parseInt(student.getBirthDate().split("-")[0]))
                .collect(toSet());
    }
    
    @Override
    public Set<Student> getByGroup(String group) {
        return studentDao.read().stream().filter(student -> group.equals(student.getGroup()))
                .collect(toSet());
    }
    
    @Override
    public Set<Student> getByUserId(int id) {
        return studentDao.read().stream().filter(student -> id == student.getUserId())
                .collect(toSet());
    }
    
}
