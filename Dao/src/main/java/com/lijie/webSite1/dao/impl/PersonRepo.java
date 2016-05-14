package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.dao.intr.IPersonRepo;
import com.lijie.webSite1.model.entity.Person;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lj on 16-3-6.
 */
@Repository
public class PersonRepo implements IPersonRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void savePerson(Person person) throws WebException {
        String sqlString="insert into person(id, name, sex, age, description) values(?,?,?,?,?)";
        try{
            jdbcTemplate.update(sqlString,person.getId(),person.getName(),person.getSex(),person.getAge(),person.getDescription());
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }

    }

    public Person getPersonById(int id) throws WebException {
        return null;
    }

    public List<Person> getAll() throws WebException {
        List<Person> persons=null;
        String sqlString="select * from person;";
        try{
            persons=jdbcTemplate.query(sqlString,new Object[]{},new PersonRowMapper());
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        return persons;
    }

    public void deletePersonById(int id) throws WebException {
        String sqlString="delete from person where id=?";
        try{
            jdbcTemplate.update(sqlString,id);
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
    }
}
