package ru.kpfu.itis.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kpfu.itis.dao.base.ShardRepository;
import ru.kpfu.itis.model.Shard;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class ShardRepositoryImpl implements ShardRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Shard> shardRowMapper = (row, rowNumber) -> Shard.builder()
            .id(row.getLong("id"))
            .sectionId(row.getLong("section_id"))
            .title(row.getString("title"))
            .content(row.getString("content"))
            .build();

    public ShardRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Shard> findById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from shard where id = ?;", shardRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Shard> findAll(int page, int limit) {
        return jdbcTemplate.query("select * from shard order by title limit ? offset ?;", shardRowMapper, limit, page);
    }

    @Override
    public Shard save(Shard item) {
        if (item.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement st = connection.prepareStatement("select f_shard_add(?, ?, ?);");
                st.setLong(1, item.getSectionId());
                st.setString(2, item.getTitle());
                st.setString(3, item.getContent());
                return st;
            }, keyHolder);
            item.setId(keyHolder.getKey().longValue());
            return item;
        } else {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement st = connection.prepareStatement("select f_shard_upd(?, ?, ?, ?);");
                st.setLong(1, item.getId());
                st.setLong(2, item.getSectionId());
                st.setString(3, item.getTitle());
                st.setString(4, item.getContent());
                return st;
            }, keyHolder);
            item.setId(keyHolder.getKey().longValue());
            return item;
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("f_shard_del(?)", id);
    }

    @Override
    public List<Shard> getSectionContent(Long sectionId, int page, int limit) {
        return jdbcTemplate.query("select * from shard where section_id = ? order by title limit ? offset ?;", shardRowMapper, sectionId, limit, page);
    }
}
