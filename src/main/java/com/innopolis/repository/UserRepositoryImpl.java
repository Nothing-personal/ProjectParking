package com.innopolis.repository;

import com.innopolis.config.JpaConfig;
import com.innopolis.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;

/**
 * Created by Kevin Khanda on 21.09.2016.
 */

@org.springframework.stereotype.Repository("userRepository")
public class UserRepositoryImpl implements UserRepository<Users> {

    @Autowired
    protected JpaConfig jpaConfig = new JpaConfig();

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(jpaConfig.configureDataSource());

    @Override
    public void addUser(Users user) {
        Object[] params = new Object[] {user.getEmail(),
                user.getPhone(), user.getPassword(),};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update("INSERT INTO users(email, phone, password) " +
                "VALUES (?, ?, ?);", params, types);
    }
}
