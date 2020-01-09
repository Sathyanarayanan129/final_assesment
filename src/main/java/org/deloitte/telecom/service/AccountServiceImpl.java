package org.deloitte.telecom.service;

import org.deloitte.telecom.dao.IAccountDao;
import org.deloitte.telecom.entities.Account;
import org.deloitte.telecom.exceptions.MobileNumberNotValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService{

    private IAccountDao dao;


    public IAccountDao getUserDao(){return dao;}

    @Autowired
    public void setUserDao(IAccountDao dao) {
        this.dao=dao;}

    @Override
    public boolean checkCredentialsById(int id, String password) {
        return dao.checkCredentialsById(id, password);
    }


    @Override
    public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
        return dao.checkCredentialsByMobileNo(mobileNo, password);
    }

    @Override
    public Account findUserById(int id) {
        return dao.findUserById(id);
    }

    @Override
    public Account save(Account user) {
        return dao.save(user);
    }

    @Override
    public Account findByMobileNo(String mobileNo) {
        Account user = dao.findByMobileNo(mobileNo);
        return user;
    }

    @Override
    public List<Account> fetchUsers(int blockSize) {
        List<Account> users = dao.fetchUsers(blockSize);
        return users;
    }


/*
    @Override
    public Account addAccount(Account acc) {
        if(acc.getMobileNo() == null || acc.getMobileNo().length() == 0 || acc.getMobileNo().length() < 10) {
            throw new MobileNumberNotValid("Mobile  number not valid...");
        }
        dao.addAccount(acc);
        return acc;
    }

    @Override
    public void recharge(String mobile, double balance) {
        if(mobile == null || mobile.length() == 0 || mobile.length() < 10) {
            throw new MobileNumberNotValid("Mobile  number not valid...");
        }
        dao.recharge(mobile, balance);
    }

    @Override
    public Account balEnquiry(String mobileNo) {
        if(mobileNo == null || mobileNo.length() == 0 || mobileNo.length() < 10) {
            throw new MobileNumberNotValid("Mobile  number not valid...");
        }
        Account acc = dao.balEnquiry(mobileNo);
        return acc;
    }

    @Override
    public Set<Account> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean credentialsCorrect(String mobile, String password) {
        return dao.credentialsCorrect(mobile, password);
    }

*/
}
