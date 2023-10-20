package edu.andrew.controller;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LocaleServlet", urlPatterns = {"/local"})
public class LocaleServlet extends HttpServlet {

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String l = request.getParameter("locale");
        Locale locale = "en".equals(l) ? Locale.US : Locale.getDefault();
        String cookieValue_Language = locale.getLanguage();
        Cookie localeCookie_lang = new Cookie("locale", cookieValue_Language);
        response.addCookie(localeCookie_lang);
        response.setLocale(locale);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }
    
    
}
