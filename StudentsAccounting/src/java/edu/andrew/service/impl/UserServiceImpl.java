package edu.andrew.service.impl;

import edu.andrew.dao.Dao;
import edu.andrew.model.User;
import java.util.Set;
import edu.andrew.service.UserService;
import static java.util.stream.Collectors.toSet;

/**
 *
 * @author Andrew
 */
public class UserServiceImpl implements UserService {
    Dao<User> userDao;

    public UserServiceImpl(Dao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public boolean create(User user) {
        return userDao.create(user) > 0;
    }

    @Override
    public Set<User> read() {
        return userDao.read();
    }

    @Override
    public boolean update(int id, String newLogin, String newPassword, String newLastName, String newFirstName, String newMiddleName, String newEmail, String newStatus) {
        User user = new User(id);
    	user.setLogin(newLogin);
        user.setPassword(newPassword);
        user.setLastName(newLastName);
        user.setFirstName(newFirstName);
        user.setMiddleName(newMiddleName);
        user.setEmail(newEmail);
        user.setStatus(newStatus);
        return userDao.update(user) > 0;
    }

    @Override
    public boolean delete(int id) {
        User user = new User(id);
        return userDao.delete(user) > 0;
    }

    @Override
    public User getById(int id) {
        return userDao.read().stream().filter(user -> id == user.getId())
                .collect(toSet()).iterator().next();
    }
    
    @Override
    public User login(String email, String password) {
        return userDao.read().stream().filter(user -> email.equals(user.getEmail()) && password.equals(user.getPassword()))
                .findFirst().orElse(null);
    }
    
}
