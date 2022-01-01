package com.file.monitoring.generic.commands.dao.mysql;

import com.file.monitoring.generic.commands.dao.NamesDAO;
import com.file.monitoring.generic.commands.dao.SomeTableDAO;
import com.file.monitoring.generic.commands.dto.NamesDTO;
import com.file.monitoring.generic.commands.dto.SomeTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SomeTableDAOImpl implements SomeTableDAO {

    @Autowired
    @Qualifier("tempDB2Admin")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT COUNT(*) FROM SomeTable", Integer.class);
    }

    @Override
    public List<SomeTableDTO> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM SomeTable",
                (rs, rowNum) ->
                        new SomeTableDTO(
                                rs.getLong("id"),
                                rs.getString("Column2"),
                                rs.getString("Column3")
                        )
        );
    }

    @Override
    public Optional<SomeTableDTO> getNameById(long id) {
       return jdbcTemplate.queryForObject("SELECT * FROM SomeTable WHERE id = ?", (rs, rowNum) ->
                Optional.of(new SomeTableDTO(
                        rs.getLong("id"),
                        rs.getString("Column2"),
                        rs.getString("Column3")
                )), id);
    }
}
