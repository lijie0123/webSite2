package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.model.entity.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lijie on 2016/5/17.
 */
public class NewsRowMapper implements RowMapper<News> {

    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        News news=new News();
        news.setId(rs.getString("id"));
        news.setContent(rs.getString("content"));
        return news;
    }
}
