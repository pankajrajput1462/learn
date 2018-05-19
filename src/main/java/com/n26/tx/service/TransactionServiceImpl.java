package com.n26.tx.service;

import com.n26.tx.dao.TransactionRepository;
import com.n26.tx.model.Amount;
import com.n26.tx.model.AmountDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * It will be responsible for the implementation of business logic.
 *
 * @author SINPANK
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> initiateTransaction(Amount amount) {
        try {
        	transactionRepository.save(amount);
            return ResponseEntity.accepted().body("Success");
        } catch (Exception e) {
            System.out.println("Transaction failed : {}"+ e.getMessage());
            return ResponseEntity.status(NO_CONTENT).build();
        }

    }

    @Override
    public ResponseEntity<AmountDetails> getTransactionDetails() {
        final Iterable<Amount> all = transactionRepository.findAll();
        System.out.println("all = " + all);
        return null;
    }
}
