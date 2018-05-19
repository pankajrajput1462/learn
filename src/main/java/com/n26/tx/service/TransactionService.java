package com.n26.tx.service;

import org.springframework.http.ResponseEntity;

import com.n26.tx.model.Amount;
import com.n26.tx.model.AmountDetails;

/**
 * @author SINPANK
 */
public interface TransactionService {

    /**
     * It will be responsible for doing transactions
     * 
     * @param amount transaction
     * @return empty body with status code
     */
    ResponseEntity<String> initiateTransaction(Amount amount);

    /**
     * Getting details of transaction
     * 
     * @return transaction details
     */
    ResponseEntity<AmountDetails> getTransactionDetails();
}
