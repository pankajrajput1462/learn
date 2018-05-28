package com.n26.tx.service;

import com.n26.tx.dao.TransactionRepository;
import com.n26.tx.model.Amount;
import com.n26.tx.model.AmountDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        	log.info("Transaction initiate");
            transactionRepository.save(amount);
            log.info("Transaction completed");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println("Transaction failed : {}" + e.getMessage());
            return ResponseEntity.status(NO_CONTENT).build();
        }

    }

    @Transactional
    @Override
    public ResponseEntity<AmountDetails> getTransactionDetails() {
    	log.info("Reading data transaction data");
    	AmountDetails amountDetails = new AmountDetails();
        try {
			List<Amount> txAmount = transactionRepository.findAllAmount();
			final double sum = txAmount.parallelStream().mapToDouble(Amount::getAmount).sum();
			final OptionalDouble max = txAmount.parallelStream().mapToDouble(Amount::getAmount).max();
			final OptionalDouble min = txAmount.parallelStream().mapToDouble(Amount::getAmount).min();
			final OptionalDouble average = txAmount.parallelStream().mapToDouble(Amount::getAmount).average();
			max.ifPresent(amountDetails::setMax);
			min.ifPresent(amountDetails::setMin);
			average.ifPresent(amountDetails::setAvg);
			amountDetails.setSum(sum);
			amountDetails.setCount(txAmount.parallelStream().count());
			log.info("Transaction completed");
			return ResponseEntity.ok().body(amountDetails);
		} catch (Exception e) {
			log.info("Data is not available");
			return ResponseEntity.noContent().build();
		}
		
    }
}
