package edu.andrew.dao.impl;

import edu.andrew.dao.Dao;
import edu.andrew.model.Student;
import java.util.Set;
import javax.sql.DataSource;

/**
 *
 * @author Andrew
 */
public class StudentDao implements Dao<Student> {
    private final DataSource dataSource;
    
    public StudentDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public int create(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Set<Student> read() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int update(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
