package top.erzhiqian.listener;

import top.erzhiqian.model.Dog;

import javax.servlet.*;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionListener;

public class DogServletContextListener implements  ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String dogBreed = context.getInitParameter("breed");
        Dog dog = new Dog(dogBreed) ;
        context.setAttribute("dog",dog);
    }
}
