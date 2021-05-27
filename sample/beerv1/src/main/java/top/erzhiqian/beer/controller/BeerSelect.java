package top.erzhiqian.beer.controller;

import top.erzhiqian.beer.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BeerSelect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        BeerExpert expert = new BeerExpert();
        List<String> brands = expert.getBrands(color);
        req.setAttribute("styles", brands);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req,resp);
    }


}
