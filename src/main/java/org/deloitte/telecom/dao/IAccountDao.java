package org.deloitte.telecom.dao;
import org.deloitte.telecom.entities.Account;

import java.util.List;

public interface IAccountDao {

    boolean checkCredentialsById(int id, String password);

    boolean checkCredentialsByMobileNo(String mobileNo, String password);

    Account findUserById(int id);

    Account save(Account user);

   Account findByMobileNo(String mobileNo);

    List<Account> fetchUsers(int blockSize);
}
