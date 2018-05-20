package com.n26.tx.service;

import com.n26.tx.dao.TransactionRepository;
import com.n26.tx.model.Amount;
import com.n26.tx.model.AmountDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.OptionalDouble;
import java.util.stream.Stream;

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
            System.out.println("Transaction failed : {}" + e.getMessage());
            return ResponseEntity.status(NO_CONTENT).build();
        }

    }

    @Transactional
    @Override
    public ResponseEntity<AmountDetails> getTransactionDetails() {

        AmountDetails amountDetails = new AmountDetails();
        Stream<Amount> txAmount = transactionRepository.findAllAmount();
        final double sum = txAmount.parallel().mapToDouble(Amount::getAmount).sum();
        final OptionalDouble max = txAmount.parallel().mapToDouble(Amount::getAmount).max();
        final OptionalDouble min = txAmount.parallel().mapToDouble(Amount::getAmount).min();
        final OptionalDouble average = txAmount.parallel().mapToDouble(Amount::getAmount).average();
        max.ifPresent(amountDetails::setMax);
        min.ifPresent(amountDetails::setMin);
        average.ifPresent(amountDetails::setAvg);
        amountDetails.setSum(sum);
        amountDetails.setCount(txAmount.parallel().count());
        return ResponseEntity.ok().body(amountDetails);
    }
}
