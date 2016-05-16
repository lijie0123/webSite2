package com.lijie.webSite1.dao.impl;

import com.lijie.webSite1.dao.intr.IAccountRepo;
import com.lijie.webSite1.model.entity.Account;
import com.lijie.webSite1.model.exception.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lijie on 2016/5/10.
 */
@Repository
public class AccountRepo implements IAccountRepo{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountById(String id) throws WebException {
        String sqlString="select * from account where id=?";
        List<Account> accounts=null;
        try{
            accounts= jdbcTemplate.query(sqlString,new Object[]{id},new AccountRowMapper());
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(accounts.isEmpty()){
            throw new WebException(100,"记录不存在");
        }else if(accounts.size()>1){
            throw new WebException(101,"记录多行");
        }
        return accounts.get(0);
    }

    @Override
    public void addAccount(Account account) throws WebException {
        String sqlString="insert into account(id, passwd, accountType, associateId) values(?,?,?,?)";
        try{
            jdbcTemplate.update(sqlString,account.getId(),account.getPassword(),account.getAccountType().getValue(),account.getAssociateId());
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
    }

    @Override
    public void delAccountById(String id) throws WebException {
        String sqlString="delete from account where id=?";
        int affectedRow=0;
        try{
            affectedRow=jdbcTemplate.update(sqlString,id);
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(affectedRow==0){
            throw new WebException(102,"未删除一行");
        }
        else if(affectedRow>1){
            throw new WebException(103,"删除多行");
        }
    }

    @Override
    public void updatePasswdById(String id, String passwd) throws WebException {
        String sqlString="update account set passwd=? where id=? ";
        int affectedRow=0;
        try{
            affectedRow=jdbcTemplate.update(sqlString,passwd,id);
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(affectedRow==0){
            throw new WebException(102,"未删除一行");
        }
        else if(affectedRow>1){
            throw new WebException(103,"删除多行");
        }
    }

    @Override
    public void updateAccount(Account account) throws WebException {
//TODO
    }

    @Override
    public boolean isIdExist(String id) throws WebException {
        String sqlString="select * from account where id=?";
        List<Account> accounts=null;
        try{
            accounts= jdbcTemplate.query(sqlString,new Object[]{id},new AccountRowMapper());
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(accounts.isEmpty())return false;
        else return true;
    }

    @Override
    public boolean isAccountValid(String id, String passwd) throws WebException {
        String sqlString="select * from account where id=? and passwd=?";
        List<Account> accounts=null;
        try{
            accounts= jdbcTemplate.query(sqlString,new Object[]{id,passwd},new AccountRowMapper());
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new WebException(2,"数据库访问出错");
        }
        if(accounts.isEmpty())return false;
        else return true;
    }
}
