package com.n26.tx.exception;

public class InvalidAccount extends TransactionException {
    public InvalidAccount(String message) {
        super(message);
    }
}
