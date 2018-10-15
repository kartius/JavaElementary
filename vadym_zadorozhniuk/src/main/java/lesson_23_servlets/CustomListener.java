package lesson_23_servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-----------------servlet init");
        System.out.println(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-----------------servlet destroy");
        System.out.println(sce.getServletContext().getServerInfo());

    }
}
