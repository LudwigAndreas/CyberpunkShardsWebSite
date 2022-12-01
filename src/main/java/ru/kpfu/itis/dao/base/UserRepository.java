package ru.kpfu.itis.dao.base;

import ru.kpfu.itis.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> getUserByUsernameAndPassword(String username, String password);

    public String getUserRoleByStatusId(Integer id);
}
