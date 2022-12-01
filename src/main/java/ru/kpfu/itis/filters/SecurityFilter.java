package ru.kpfu.itis.filters;

import ru.kpfu.itis.dao.base.UserRepository;
import ru.kpfu.itis.exeptions.UserExistenceException;
import ru.kpfu.itis.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter extends HttpFilter {
    private static final String[] securedPaths = new String[]{"/profile"};
    private UserRepository userRepository;
    private UserService userService;

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
        userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean prot = false;
        for (String path: securedPaths) {
            if (path.equals(req.getRequestURI().substring(req.getContextPath().length()))) {
                prot = true;
                break;
            }
        }
        if (prot && !userService.isNonAnonymous(req, res)) {
            res.sendRedirect(req.getContextPath() + "/signin");
        } else {
            if (userService.isNonAnonymous(req, res)) {
                try {
                    req.setAttribute("user", userService.getUser(req, res));
                } catch (UserExistenceException e) {
                    res.sendRedirect(req.getContextPath() + "/signin");
                }
            }
            chain.doFilter(req, res);
        }
    }
}
