package com.n26.tx.endpoint;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.tx.model.Amount;
import com.n26.tx.model.AmountDetails;
import com.n26.tx.service.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This API will be responsible for doing transaction related activity. Every time when transaction is happening, this api will be
 * invoked. We can get real time statics data for 60 sec time span.
 * 
 * @author SINPANK
 */
@RestController
@Api(tags = "Transaction Statistics")
public class TransactionDetailsEndpoint {

    @Autowired
    private TransactionService transactionService;

    /**
     * For adding amount into to database. It will return empty response {} after successful insertion of data.
     * 
     * @param amount transaction amount
     * @return empty body with status code 201 or 204
     */
    @ApiOperation(value = "Initiate transaction")
    @PostMapping(path = "/transactions", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> transactionInitiated(@RequestBody Amount amount) {

        return transactionService.initiateTransaction(amount);
    }

    /**
     * It will result the details for transaction which contains aggregate amount,average ,maximum , minimum and total transaction
     * count.
     * 
     * @return transaction details for 60 second
     */
    @ApiOperation(value = "Get transaction details")
    @GetMapping(path = "/statistics", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AmountDetails> transactionInitiated() {

        return transactionService.getTransactionDetails();
    }
}
