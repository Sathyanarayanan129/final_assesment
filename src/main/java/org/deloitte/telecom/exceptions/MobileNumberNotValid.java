package org.deloitte.telecom.exceptions;

public class MobileNumberNotValid extends RuntimeException {
    public MobileNumberNotValid(String msg) {
        super(msg);
    }
}
