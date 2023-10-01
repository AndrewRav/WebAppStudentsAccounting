package edu.andrew.service.impl;

import edu.andrew.dao.Dao;
import edu.andrew.model.Student;
import edu.andrew.service.Service;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public class StudentServiceImpl implements Service<Student> {
    Dao studentDao;

    public StudentServiceImpl(Dao studentDao) {
        this.studentDao = studentDao;
    }
    
    @Override
    public boolean create(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Student> read() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(int id, String newName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Student getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
