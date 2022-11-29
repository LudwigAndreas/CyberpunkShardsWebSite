package ru.kpfu.itis.controllers;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class HomePageServlet extends HttpServlet {
    private String name;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = (String) getServletContext().getAttribute("name");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", name);
        getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);
    }
}
