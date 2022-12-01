package ru.kpfu.itis.controllers;

import ru.kpfu.itis.dao.base.UserRepository;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/signin")
public class SignInPageServlet extends HttpServlet {
    private UserRepository userRepository;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/security/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        if (username != null && password != null) {
            Optional<User> user = userRepository.getUserByUsernameAndPassword(username, password);
            if (user.isPresent()) {
                userService.auth(user.get(), req, resp);
                resp.sendRedirect(getServletContext().getContextPath() + "/profile");
            } else {
                req.setAttribute("message", "Invalid Username or Password");
            }
        }
    }
}
