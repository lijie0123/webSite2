package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.model.entity.Account;
import com.lijie.webSite1.model.enumeration.AccountType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lijie on 2016/5/10.
 */
public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account=new Account();
        account.setId(rs.getString("id"));
        account.setPassword(rs.getString("passwd"));
        account.setAccountType(AccountType.toAccountType(rs.getInt("accountType")));
        account.setAssociateId(rs.getString("associateId"));
        return account;
    }
}
