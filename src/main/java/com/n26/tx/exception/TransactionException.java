package com.n26.tx.exception;

public class TransactionException extends Exception {
    public TransactionException() {
    }

    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(Throwable throwable) {
        super(throwable);
    }

    public TransactionException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
