package ru.vsprog.springinaction.chapter6;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vsa
 * Date: 13.11.14.
 */
public class SimpleJdbcTemplateSpitterDao {
    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname) values (?,?,?)";
    private static final String SQL_SELECT_SPITTER_BY_ID =
            "select id, username, fullname from spitter where id = ?";

    private SimpleJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail());
        spitter.setId(queryForIdentity());
    }

    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_ID,
                new ParameterizedRowMapper<Spitter>() {
                    @Override
                    public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setId(resultSet.getLong(1));
                        spitter.setUsername(resultSet.getString(2));
                        spitter.setPassword(resultSet.getString(3));
                        spitter.setFullName(resultSet.getString(4));
                        return spitter;
                    }
                },
                id
        );
    }

    private int queryForIdentity() {
        return 1;
    }
}
