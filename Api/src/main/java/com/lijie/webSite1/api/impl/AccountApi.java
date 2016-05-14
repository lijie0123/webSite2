package com.lijie.webSite1.api.impl;

import com.lijie.webSite1.api.app.IAccountApi;
import com.lijie.webSite1.dao.intr.IAccountRepo;
import com.lijie.webSite1.model.entity.Account;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lijie on 2016/5/10.
 */
@Service
public class AccountApi implements IAccountApi{
    @Autowired
    private IAccountRepo accountRepo;
    public boolean isAccountValid(String id, String passwd) {
        boolean isValid=false;
        try {
            isValid=accountRepo.isAccountValid(id,passwd);
        } catch (WebException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    public Account getAccountById(String id) {
        try {
            return accountRepo.getAccountById(id);
        } catch (WebException e) {
            e.printStackTrace();
        }
        return null;
    }

}
