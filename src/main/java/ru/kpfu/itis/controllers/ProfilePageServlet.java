package ru.kpfu.itis.controllers;

import ru.kpfu.itis.dao.base.UserRepository;
import ru.kpfu.itis.exeptions.UserExistenceException;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfilePageServlet extends HttpServlet {
    private UserService userService;
    private User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            user = userService.getUser(req, resp);
        } catch (UserExistenceException e) {
            resp.sendRedirect(getServletContext().getContextPath() + "/signin");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/profile.jsp").forward(req, resp);
    }
}
