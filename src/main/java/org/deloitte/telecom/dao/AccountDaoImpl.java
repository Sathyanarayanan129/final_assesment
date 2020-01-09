package org.deloitte.telecom.dao;

import org.deloitte.telecom.entities.Account;
import org.deloitte.telecom.exceptions.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class AccountDaoImpl implements IAccountDao{

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }





    @Override
    public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
        Account user = findByMobileNo(mobileNo);
        System.out.println("inside checkCredent args,MOBILEnO="+mobileNo+" pass="+password);
        System.out.println("fetched account="+user.getPassword());
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }


    @Override
    public Account findUserById(int id) {
        Account user = entityManager.find(Account.class, id);
        return user;
    }

    @Override
    public Account findByMobileNo(String mobileNo) {
        try {
            String jql = "from Account where mobileNo=:mob";
            TypedQuery<Account> query = entityManager.createQuery(jql, Account.class);
            query.setParameter("mob", mobileNo);
            Account result = query.getSingleResult();
            return result;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public boolean checkCredentialsById(int id, String password) {
        Account user = entityManager.find(Account.class, id);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }



    @Override
    public List<Account> fetchUsers(int blockSize) {
        String jql = "from AppUser";
        TypedQuery<Account> query = entityManager.createQuery(jql, Account.class);
        query.setMaxResults(blockSize);
        List<Account> list = query.getResultList();
        return list;
    }

    public boolean mobileNumberExists(String mobileNo) {
        Account user = findByMobileNo(mobileNo);
        return user != null;
    }

    @Override
    public Account save(Account user) {
        System.out.println("inside save,user=" + user);
        String phone = user.getMobileNo();
        boolean exists = mobileNumberExists(phone);
        if (exists) {
            throw new MobileNoAlreadyExistsException("mobile no exists");
        }
        user = getEntityManager().merge(user);
        return user;
    }
}
/* public AccountDaoImpl() {
        Account acc = new Account("9895553766", "Pranav", "pre-paid", 100, "abc");
        store.put(acc.getMobileNo(), acc);
    }
     @Override
    public Account balEnquiry(String mobileNo) {
        Account acc = store.get(mobileNo);
        if(acc == null) {
            throw new NumberNotFound("Number does not exists...");
        }
        return acc;
    }
    @Override
    public void recharge(String mobile, double balance) {
        Account acc = store.get(mobile);
        if(acc == null) {
            throw new NumberNotFound("Number does not exists...");
        }
        double newBal = acc.getBalance() + balance;
        acc.setBalance(newBal);
    }
    @Override
    public Account addAccount(Account acc) {
       store.put(acc.getMobileNo(), acc);
       return acc;
    }

    @Override
    public Account save(Account acc) {
        System.out.println("inside save,user=" + acc);
        String phone = acc.getMobileNo();
        boolean exists = mobileNumberExists(phone);
        if (exists) {
            throw new MobileNoAlreadyExistsException("mobile no exists");
        }
        acc = getEntityManager().merge(user);
        return user;
    }

*/