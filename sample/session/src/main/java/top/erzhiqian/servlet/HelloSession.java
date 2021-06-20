package top.erzhiqian.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloSession extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Session!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" +message + "</h1>");
        out.println("<h1>" +"Test Session Attributes" + "</h1>");
        HttpSession session = request.getSession();
        if (session.isNew()){
            out.println("This is a new Session ");
        }else {
            out.println("Welcome back.");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
