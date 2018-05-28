package com.n26.tx.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.n26.tx.model.Amount;
import com.n26.tx.model.AmountDetails;
import com.n26.tx.service.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionDetailsEndpoint.class)
public class TransactionDetailsEndpointTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    private TransactionService transactionService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void whenGivenAmount_ShouldReturnSuccess() throws Exception {
        final ResponseEntity<AmountDetails> amountDetails = new ResponseEntity<>(HttpStatus.OK);
        given(transactionService.getTransactionDetails()).willReturn(amountDetails);
        mvc.perform(get("/statistics").contentType(APPLICATION_PROBLEM_JSON_UTF8_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void transactionInitiated1() throws Exception {
        Amount amount = new Amount();
        amount.setAmount(66.2);
        given(transactionService.initiateTransaction(amount)).willReturn(new ResponseEntity<>(CREATED));
        mvc.perform(post("/transactions").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(mapper.writeValueAsBytes(amount))).
                andExpect(MockMvcResultMatchers.status().isCreated());
    }
}