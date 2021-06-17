package top.erzhiqian.servlet;

import top.erzhiqian.model.Dog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DogListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Test context attributes set by listener");
        out.println("<br>");
        Dog dog = (Dog) getServletContext().getAttribute("dog");
        out.println("Dog's breed is: " + dog.getBreed());

    }
}
