package top.erzhiqian.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog implements HttpSessionBindingListener {
    private final String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(" I know  I'm in a session");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(" I know  I'm no longer part of a session");
    }
}
