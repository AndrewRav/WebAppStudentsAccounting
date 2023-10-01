package edu.andrew.dao.impl;

import edu.andrew.dao.Dao;
import edu.andrew.model.Student;
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
public class StudentDao implements Dao<Student> {
    private final DataSource dataSource;
    
    public StudentDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public int create(Student student) {
        try (Connection conn = dataSource.getConnection()) { // Установка соединения (получение соединения)
            int id;
            
            String sql = "INSERT INTO students(user_id, last_name, first_name, middle_name, birth_date, tel_number, faculty, course, groupName) values(?,?,?,?,?,?,?,?,?)"; // Формирование запроса добавления
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) { // В подготовленный запрос передаём строку с запросом
                preparedStatement.setInt(1, student.getUserId()); // Переданный запрос меняем, указываем позицию ? и чем мы его занимаем, отсчёт с 1
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setString(3, student.getFirstName());
                preparedStatement.setString(4, student.getMiddleName());
                preparedStatement.setString(5, student.getBirthDate());
                preparedStatement.setString(6, student.getPhoneNumber());
                preparedStatement.setString(7, student.getFaculty());
                preparedStatement.setInt(8, student.getCourse());
                preparedStatement.setString(9, student.getGroup());
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
    public Set<Student> read() {
        String req = "SELECT * from student";
        Set<Student> students;
        try (Connection conn = dataSource.getConnection()) {            
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(req)) {
                students = new HashSet<>();
                while (rs.next()) { // Пока есть записи 
                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    String lastName = rs.getString("last_name");
                    String firstName = rs.getString("first_name");
                    String middleName = rs.getString("middle_name");
                    String birthDate = rs.getString("birth_date");
                    String phoneNumber = rs.getString("tel_number");
                    String faculty = rs.getString("faculty");
                    int course = rs.getInt("course");
                    String groupName = rs.getString("groupName");
                    students.add(new Student(id, userId, lastName, firstName, middleName, birthDate, phoneNumber, faculty, course, groupName));
                }
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }

    @Override
    public int update(Student student) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE students SET user_id = ?, last_name = ?, first_name = ?, middle_name = ?, birth_date = ?, tel_number = ?, faculty = ?, course = ?, groupName = ? WHERE id = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, student.getUserId());
                pst.setString(2, student.getLastName());
                pst.setString(3, student.getFirstName());
                pst.setString(4, student.getMiddleName());
                pst.setString(5, student.getBirthDate());
                pst.setString(6, student.getPhoneNumber());
                pst.setString(7, student.getFaculty());
                pst.setInt(8, student.getCourse());
                pst.setString(9, student.getGroup());
                pst.setInt(10, student.getId());
                return pst.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Student student) {
        try (Connection conn = dataSource.getConnection()) {            
            String query = "DELETE FROM students WHERE id = ?";
            try (PreparedStatement preparedStmt = conn.prepareStatement(query)) {
                preparedStmt.setInt(1, student.getId());
                int res = preparedStmt.executeUpdate();
                return res;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
}
