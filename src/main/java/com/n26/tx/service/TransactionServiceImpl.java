package com.n26.tx.service;

import com.n26.tx.dao.TransactionRepository;
import com.n26.tx.model.Amount;
import com.n26.tx.model.AmountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * It will be responsible for the implementation of business logic.
 *
 * @author SINPANK
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository repository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> initiateTransaction(Amount amount) {
        return null;
    }

    @Override
    public ResponseEntity<AmountDetails> getTransactionDetails() {
        return null;
    }
}
