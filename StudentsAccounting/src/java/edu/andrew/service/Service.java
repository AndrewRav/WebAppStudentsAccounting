package edu.andrew.service;

import java.util.Set;

/**
 *
 * @author Andrew
 * @param <Type>
 */
public interface Service<Type> {
    boolean create(Type entity);
    Set<Type> read();
    boolean update(int id, String newLogin, String newPassword, String newLastName, String newFirstName, String newMiddleName, String newEmail, String newStatus);
    boolean delete(int id);
    Type getById(int id);
}
