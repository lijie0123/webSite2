package com.lijie.webSite1.api.app;

import com.lijie.webSite1.model.entity.News;
import com.lijie.webSite1.model.exception.WebException;

import java.util.List;

/**
 * Created by lijie on 2016/5/17.
 */
public interface INewsApi {
    public List<News> getAll() throws WebException;
}
