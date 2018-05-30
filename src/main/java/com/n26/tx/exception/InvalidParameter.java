package com.n26.tx.exception;

public class InvalidParameter extends  TransactionException {
    public InvalidParameter(String message) {
        super(message);
    }
}
