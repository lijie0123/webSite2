package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.dao.intr.INewsRepo;
import com.lijie.webSite1.model.entity.News;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lijie on 2016/5/17.
 */
@Repository
public class NewsRepo implements INewsRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<News> getAll() throws WebException {
        List<News> newses=null;
        String sqlString="select * from news;";
        try{
            newses=jdbcTemplate.query(sqlString,new Object[]{},new NewsRowMapper());
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        return newses;
    }
}
