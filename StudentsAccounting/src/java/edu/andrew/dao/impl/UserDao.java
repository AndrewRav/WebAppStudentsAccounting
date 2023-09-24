package edu.andrew.dao.impl;

import edu.andrew.dao.Dao;
import edu.andrew.model.User;
import java.util.Set;
import javax.sql.DataSource;

/**
 *
 * @author Andrew
 */
public class UserDao implements Dao<User> {
    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int create(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<User> read() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
