package com.file.monitoring.generic.commands.dao.mysql;

import com.file.monitoring.generic.commands.dao.NamesDAO;
import com.file.monitoring.generic.commands.dto.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class NamesDAOImpl implements NamesDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT COUNT(*) FROM Names", Integer.class);
    }

    @Override
    public List<Names> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Names",
                (rs, rowNum) ->
                        new Names(
                                rs.getLong("id"),
                                rs.getString("FName"),
                                rs.getString("LName")
                        )
        );
    }

    @Override
    public Optional<Names> getNameById(long id) {
       return jdbcTemplate.queryForObject("SELECT * FROM Names WHERE id = ?", (rs, rowNum) ->
                Optional.of(new Names(
                        rs.getLong("id"),
                        rs.getString("FName"),
                        rs.getString("LName")
                )), id);
    }
}
