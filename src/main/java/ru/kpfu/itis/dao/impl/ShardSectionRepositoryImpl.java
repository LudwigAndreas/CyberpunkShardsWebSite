package ru.kpfu.itis.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kpfu.itis.dao.base.ShardSectionRepository;
import ru.kpfu.itis.model.ShardSection;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class ShardSectionRepositoryImpl implements ShardSectionRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<ShardSection> shardSectionRowMapper = (row, rowNumber) -> ShardSection.builder()
            .id(row.getLong("id"))
            .title(row.getString("name"))
            .build();

    public ShardSectionRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<ShardSection> findById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from shard where id = ?;", shardSectionRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<ShardSection> findAll(int page, int limit) {
        return jdbcTemplate.query("select * from shard_section order by name limit ? offset ?;", shardSectionRowMapper, limit, page);
    }

    @Override
    public ShardSection save(ShardSection item) {
        if (item.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement st = connection.prepareStatement("select f_shardsection_add(?);");
                st.setString(1, item.getTitle());
                return st;
            }, keyHolder);
            item.setId(keyHolder.getKey().longValue());
            return item;
        } else {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement st = connection.prepareStatement("select f_shardsection_upd(?, ?);");
                st.setLong(1, item.getId());
                st.setString(2, item.getTitle());
                return st;
            }, keyHolder);
            item.setId(keyHolder.getKey().longValue());
            return item;
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("select f_shardsection_del(?)", id);
    }
}
