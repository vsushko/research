package ru.vsprog.springinaction.chapter6;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import ru.vsprog.springinaction.chapter7.Spittle;

/**
 * Created by vsa
 * Date: 13.11.14.
 */
public class JdbcSpitterDAO extends SimpleJdbcDaoSupport implements SpitterDAO {

    @Override
    public void saveSpittle(Spittle spittle) {

    }
}
