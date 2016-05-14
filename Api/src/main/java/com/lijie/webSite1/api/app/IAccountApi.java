package com.lijie.webSite1.api.app;

import com.lijie.webSite1.model.entity.Account;

/**
 * Created by lijie on 2016/5/10.
 */
public interface IAccountApi {
    public boolean isAccountValid(String id, String passwd);
    public Account getAccountById(String id);
}
