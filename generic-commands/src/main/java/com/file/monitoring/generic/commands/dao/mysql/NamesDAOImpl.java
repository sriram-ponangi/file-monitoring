package com.file.monitoring.generic.commands.dao.mysql;

import com.file.monitoring.generic.commands.dao.NamesDAO;
import com.file.monitoring.generic.commands.dto.NamesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NamesDAOImpl implements NamesDAO {

    @Autowired
    @Qualifier("tempDB1Admin")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT COUNT(*) FROM Names", Integer.class);
    }

    @Override
    public List<NamesDTO> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Names",
                (rs, rowNum) ->
                        new NamesDTO(
                                rs.getLong("id"),
                                rs.getString("FName"),
                                rs.getString("LName")
                        )
        );
    }

    @Override
    public Optional<NamesDTO> getNameById(long id) {
       return jdbcTemplate.queryForObject("SELECT * FROM Names WHERE id = ?", (rs, rowNum) ->
                Optional.of(new NamesDTO(
                        rs.getLong("id"),
                        rs.getString("FName"),
                        rs.getString("LName")
                )), id);
    }
}
