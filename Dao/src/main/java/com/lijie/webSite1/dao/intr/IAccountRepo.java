package com.lijie.webSite1.dao.intr;

import com.lijie.webSite1.model.entity.Account;
import com.lijie.webSite1.model.exception.WebException;

/**
 * Created by lijie on 2016/5/10.
 */
public interface IAccountRepo {
    public Account getAccountById(String id) throws WebException;
    public void addAccount(Account account) throws WebException;
    public void delAccountById(String id) throws WebException;
    public void updatePasswdById(String id,String passwd) throws WebException;
    public void updateAccount(Account account) throws WebException;
    public boolean isIdExist(String id)throws WebException;
    public boolean isAccountValid(String id, String passwd)throws WebException;
}
