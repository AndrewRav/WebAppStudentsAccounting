package edu.andrew.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
@WebFilter(urlPatterns = {"/*"})
public class SessionTimeOutFilter implements Filter {

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        if (session != null && !session.isNew()) {
            chain.doFilter(req, resp);
        } else {
            if (session != null) {
                session.invalidate();
            }
            req.getRequestDispatcher("/WEB-INF/jsp/timeout.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
