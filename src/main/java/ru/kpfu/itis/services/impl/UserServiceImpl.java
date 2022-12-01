package ru.kpfu.itis.services.impl;

import ru.kpfu.itis.dao.impl.UserRepositoryImpl;
import ru.kpfu.itis.exeptions.UserExistenceException;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServiceImpl implements UserService {
    @Override
    public void auth(User user, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("userRoleId", user.getStatusId());
    }

    @Override
    public boolean isNonAnonymous(HttpServletRequest req, HttpServletResponse resp) {
        return req.getSession().getAttribute("user") != null;
    }

    @Override
    public int getRoleId(HttpServletRequest req, HttpServletResponse resp) {
        return (int) req.getSession().getAttribute("userRoleId");
    }

    private enum Role {
        DEVELOPER("Developer"),
        OWNER("Owner"),
        ADMIN("Admin"),
        VIEWER("Viewer");

        private final String text;

        Role(String text) {
            this.text = text;
        }
    }

    public String getUserRoleByStatusId(Integer id) {
        switch (id) {
            case 0:
                return Role.DEVELOPER.text;
            case 1:
                return Role.OWNER.text;
            case 2:
                return Role.ADMIN.text;
            default:
                return Role.VIEWER.text;
        }
    }

    @Override
    public User getUser(HttpServletRequest req, HttpServletResponse resp) throws UserExistenceException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null)
            throw new UserExistenceException();
        user.setStatus(getUserRoleByStatusId(user.getStatusId()));
        return user;
    }
}
