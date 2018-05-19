package com.n26.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Starting point of the application.Transaction management is enabled by the {link @EnableTransactionManagement }
 * 
 * @author SINPANK
 */
@SpringBootApplication
@EnableTransactionManagement
public class StatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class, args);
    }

}
