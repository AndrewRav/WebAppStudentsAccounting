package edu.andrew.controller;

import edu.andrew.dao.Dao;
import edu.andrew.dao.impl.StudentDao;
import edu.andrew.dao.impl.UserDao;
import edu.andrew.service.Service;
import edu.andrew.service.impl.StudentServiceImpl;
import edu.andrew.service.impl.UserServiceImpl;
import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

/**
 *
 * @author Andrew
 */
public abstract class InitServlet extends HttpServlet {
    private @Resource(name = "jdbc/studentdb") // Использование листнера
    DataSource dataSource;
    protected Dao studentDao;
    protected Dao userDao;
    protected Service studentService;
    protected Service userService;

    @Override
    public void init() { // Инициализация объектов с которыми работает сервлеты
        studentDao = new StudentDao(dataSource);
        studentService = new StudentServiceImpl(studentDao);
        
        userDao = new UserDao(dataSource);
        userService = new UserServiceImpl(userDao);
    }  
    
}
