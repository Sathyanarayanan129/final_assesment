package org.deloitte.telecom.exceptions;

public class MobileNoAlreadyExistsException extends RuntimeException {
    public MobileNoAlreadyExistsException(String msg) {
        super(msg);
    }
}
