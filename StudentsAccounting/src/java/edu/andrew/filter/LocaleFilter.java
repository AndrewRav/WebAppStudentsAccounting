package edu.andrew.filter;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/*"})
public class LocaleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest) request;
        Cookie[] cookies = r.getCookies();
        String l = Optional.ofNullable(cookies).map(Stream::of)
                .orElseGet(Stream::empty)
                .filter(c -> "locale".equals(c.getName()))
                .findAny().orElse(new Cookie("locale", "ru"))
                .getValue();
        request.getServletContext().setAttribute("locale", l);
        Locale locale = "en".equals(l) ? Locale.US : Locale.getDefault();
        response.setLocale(locale);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
