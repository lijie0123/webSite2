package com.lijie.webSite1.api.impl;

import com.lijie.webSite1.api.app.INewsApi;
import com.lijie.webSite1.dao.intr.INewsRepo;
import com.lijie.webSite1.model.entity.News;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lijie on 2016/5/17.
 */
@Service
public class NewsApi implements INewsApi {
    @Autowired
    private INewsRepo newsRepo;
    public List<News> getAll() throws WebException {
       return newsRepo.getAll();
    }
}
