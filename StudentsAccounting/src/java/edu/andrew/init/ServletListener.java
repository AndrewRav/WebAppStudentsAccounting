package edu.andrew.init;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 *
 * @author Andrew
 */
@WebListener
public class ServletListener implements ServletContextListener {
    
    @SuppressWarnings("unused")
    private DataSource datasource;

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) { // Доступен для всех сервлетов из нашего проекта
        InitialContext initContext;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env"); // Ищет окружение 
            datasource = (DataSource) envContext.lookup("jdbc/studentdb"); // Ищет в окружение по имени; добавляем соединения к сервлетам для дальнейшй работы
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
