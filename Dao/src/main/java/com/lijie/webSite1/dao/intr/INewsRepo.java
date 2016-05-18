package com.lijie.webSite1.dao.intr;

import com.lijie.webSite1.model.entity.News;
import com.lijie.webSite1.model.exception.WebException;

import java.util.List;

/**
 * Created by lijie on 2016/5/17.
 */
public interface INewsRepo {
    public List<News> getAll() throws WebException;
}
