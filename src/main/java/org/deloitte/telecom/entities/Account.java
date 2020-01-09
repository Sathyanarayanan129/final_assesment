package org.deloitte.telecom.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Account {
    String mobileNo;
    String name;
    String accountType;
    double balance;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String mobileNo, String name, String accountType, double balance, String password) {
        this.mobileNo = mobileNo;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.password = password;
    }
    public Account(String name,String password)
    {
        this.name = name;
        this.password = password;
    }

    public Account() {
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Id
    @GeneratedValue
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return account.id==this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "mobileNo='" + mobileNo + '\'' +
                ", name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
