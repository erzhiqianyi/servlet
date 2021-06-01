package top.erzhiqian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ContextServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        String adminEmail = getServletContext().getInitParameter("CtxAdminEmail");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + adminEmail + "</h1>");
        out.println("</body></html>");
    }
}
