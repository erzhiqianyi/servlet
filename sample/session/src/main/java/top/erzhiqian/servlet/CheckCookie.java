package top.erzhiqian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if (null != cookies){
            for ( int i = 0 ; i < cookies.length ; i++){
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("username")){
                    String userName = cookie.getValue();
                    out.println("Hello" + userName);
                    break;
                }
            }
        }

    }
}
