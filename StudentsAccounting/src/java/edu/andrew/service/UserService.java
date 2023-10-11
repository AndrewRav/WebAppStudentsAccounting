package edu.andrew.service;

import edu.andrew.model.User;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public interface UserService {
    boolean create(User user);
    Set<User> read();
    boolean update(int id, String newLogin, String newPassword, String newLastName, String newFirstName, String newMiddleName, String newEmail, String newStatus);
    boolean delete(int id);
    User getById(int id);
    User login(String email, String password);
}
