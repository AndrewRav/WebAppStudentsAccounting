package edu.andrew.dao;

import java.util.Set;

/**
 *
 * @author Andrew
 * @param <Type>
 */
public interface Dao<Type> {
    int create(Type entity);
    Set<Type> read();
    int update(Type entity);
    int delete(Type entity);
}
