package org.deloitte.telecom.dto;

import org.deloitte.telecom.entities.Account;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData {

    private Account account;

    public void setAccount(Account acc) {
        this.account = acc;
    }

    public Account getAccount() {
        return account;
    }
}
