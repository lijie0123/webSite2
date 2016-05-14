package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.model.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lj on 16-3-6.
 */
public class PersonRowMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person=new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setSex(resultSet.getInt("sex"));
        person.setDescription(resultSet.getString("description"));
        return person;
    }
}
