package top.erzhiqian.listener;

import top.erzhiqian.model.Dog;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DogServletContextListener implements  ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(" dog servlet context listener initialized");
        ServletContext context = sce.getServletContext();
        String dogBreed = context.getInitParameter("breed");
        Dog dog = new Dog(dogBreed) ;
        context.setAttribute("dog",dog);
    }
}
