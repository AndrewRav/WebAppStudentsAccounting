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
    boolean update(int id, String newName);
    boolean delete(int id);
    Type getById(int id);
}
