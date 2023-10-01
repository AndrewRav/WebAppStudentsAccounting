package edu.andrew.dao.impl;

import edu.andrew.dao.Dao;
import edu.andrew.model.Student;
import edu.andrew.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
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
        try (Connection conn = dataSource.getConnection()) { // Установка соединения (получение соединения)
            int id;
            
            String sql = "INSERT INTO users(login, password, last_name, first_name, middle_name, email, status) values(?,?,?,?,?,?,?)"; // Формирование запроса добавления
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) { // В подготовленный запрос передаём строку с запросом
                preparedStatement.setString(1, user.getLogin()); // Переданный запрос меняем, указываем позицию ? и чем мы его занимаем, отсчёт с 1
                preparedStatement.setString(2,user.getPassword());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getFirstName());
                preparedStatement.setString(5, user.getMiddleName());
                preparedStatement.setString(6, user.getEmail());
                preparedStatement.setString(7, user.getStatus());
                int affectedRows = preparedStatement.executeUpdate(); // Количество добавленных строчек

                if (affectedRows == 0) { // Если строчки не добавлены выбрасывается исключение 
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                sql = "SELECT * FROM student ORDER BY id DESC LIMIT 1"; // Сортируем в обратном порядке записи(от максимального до минимального) в бд и получаем первую строчку
                try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                    if (rs.next()) { // Если результат имеет хотя бы 1 запись
                        id = rs.getInt("id"); // Берём id свежесозданной строчки 
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained");
                    }
                }
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        } 
    }

    @Override
    public Set<User> read() {
        String req = "SELECT * from users";
        Set<User> users;
        try (Connection conn = dataSource.getConnection()) {            
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(req)) {
                users = new HashSet<>();
                while (rs.next()) { // Пока есть записи 
                    int id = rs.getInt("id");
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    String lastName = rs.getString("last_name");
                    String firstName = rs.getString("first_name");
                    String middleName = rs.getString("middle_name");
                    String email = rs.getString("email");
                    String status = rs.getString("status");
                    users.add(new User(id, login, password, lastName, firstName, middleName, email, status));
                }
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }

    @Override
    public int update(User user) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE users SET login = ?, password = ?, last_name = ?, first_name = ?, middle_name = ?, email = ?, status = ? WHERE id = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, user.getLogin());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getLastName());
                pst.setString(4, user.getFirstName());
                pst.setString(5, user.getMiddleName());
                pst.setString(6, user.getEmail());
                pst.setString(7, user.getStatus());
                pst.setInt(8, user.getId());
                return pst.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(User user) {
        try (Connection conn = dataSource.getConnection()) {            
            String query = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement preparedStmt = conn.prepareStatement(query)) {
                preparedStmt.setInt(1, user.getId());
                int res = preparedStmt.executeUpdate();
                return res;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
}
