package ru.kpfu.itis.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kpfu.itis.dao.base.UserRepository;
import ru.kpfu.itis.model.User;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> userRowMapper = (row, rowNumber) -> User.builder()
            .id(row.getLong("id"))
            .firstname(row.getString("firstname"))
            .lastname(row.getString("lastname"))
            .username(row.getString("username"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .statusId(row.getInt("status_id"))
            .build();

    public UserRepositoryImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from shard_user where username = ? and password = MD5(?);", userRowMapper, username, password));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from shard_user where id = ?;", userRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll(int page, int limit) {
        return jdbcTemplate.query("select * from shard_user order by username limit ? offset ?;", userRowMapper, limit, page);
    }

    @Override
    public User save(User item) {
        if (item.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement st = connection.prepareStatement("select f_shard_user_add(?, ?, ?, ?, MD5(?), ?);");
                st.setString(1, item.getFirstname());
                st.setString(2, item.getLastname());
                st.setString(3, item.getUsername());
                st.setString(4, item.getEmail());
                st.setString(5, item.getPassword());
                st.setInt(6, item.getStatusId());
                return st;
            }, keyHolder);
            item.setId(keyHolder.getKey().longValue());
            return item;
        } else {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement st = connection.prepareStatement("select f_shard_user_upd(?, ?, ?, ?, ?, ?, ?);");
                st.setLong(1, item.getId());
                st.setString(2, item.getFirstname());
                st.setString(3, item.getLastname());
                st.setString(4, item.getUsername()); //TODO: do password changing
                st.setString(5, item.getEmail());
                st.setString(6, item.getPassword());
                st.setInt(7, item.getStatusId());
                return st;
            }, keyHolder);
            item.setId(keyHolder.getKey().longValue());
            return item;
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("select f_sharduser_del(?)", id);
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

    @Override
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
}
