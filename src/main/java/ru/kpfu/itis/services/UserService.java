package ru.kpfu.itis.services;

import ru.kpfu.itis.exeptions.UserExistenceException;
import ru.kpfu.itis.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    public void auth(User user, HttpServletRequest req, HttpServletResponse resp);

    public boolean isNonAnonymous(HttpServletRequest req, HttpServletResponse resp);

    public int getRoleId(HttpServletRequest req, HttpServletResponse resp);

    public User getUser(HttpServletRequest req, HttpServletResponse resp) throws UserExistenceException;
}
