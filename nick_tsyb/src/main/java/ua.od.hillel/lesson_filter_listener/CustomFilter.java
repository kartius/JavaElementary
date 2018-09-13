package ua.od.hillel.lesson_filter_listener;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "filter",urlPatterns = {"/servlet/*"})
public class CustomFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("filtering........");

        filterChain.doFilter(servletRequest,servletResponse);








    }

    @Override
    public void destroy() {

    }
}
