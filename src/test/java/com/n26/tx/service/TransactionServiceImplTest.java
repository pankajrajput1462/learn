package com.n26.tx.service;

import com.n26.tx.dao.TransactionRepository;
import com.n26.tx.model.Amount;
import com.n26.tx.model.AmountDetails;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TransactionServiceImplTest {

    @Mock
    TransactionRepository repository;

    @InjectMocks
    TransactionServiceImpl service;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void initiateTransaction() {

        final Amount value = new Amount();
        value.setAmount(66.3);
        when(repository.save(any(Amount.class))).thenReturn(value);
        final ResponseEntity<String> stringResponseEntity = service.initiateTransaction(value);
        assertNotNull(stringResponseEntity);
    }

    @Test
    public void getTransactionDetails() {
        List<Amount> amountList = new ArrayList<>();
        Amount amount1= new Amount();
        amount1.setAmount(28.2);
        Amount amount2= new Amount();
        amount2.setAmount(22.2);
        amountList.add(amount1);
        amountList.add(amount2);
        when(repository.findAllAmount()).thenReturn(amountList);
        final ResponseEntity<AmountDetails> transactionDetails = service.getTransactionDetails();
        final AmountDetails body = transactionDetails.getBody();
        assertNotNull(body);
        assertEquals("Average", 25.2, body.getAvg(), 25);
        assertEquals("Sum", 50.4, body.getSum(), 50);
        assertEquals("Max", 25.2, body.getMax(), 26);
        assertEquals("Min", 22.2, body.getMin(), 22);
        assertEquals("Count", 2, body.getCount(), 2);
    }
}