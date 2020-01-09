package org.deloitte.telecom.service;

import org.deloitte.telecom.entities.Account;

import java.util.List;
import java.util.Set;

public interface IAccountService {
    boolean checkCredentialsById(int id, String password);

    boolean checkCredentialsByMobileNo(String mobileNo, String password);

   Account findUserById(int id);

   Account  save(Account user);

    Account findByMobileNo(String mobileNo);

    List<Account> fetchUsers(int blockSize);
}
