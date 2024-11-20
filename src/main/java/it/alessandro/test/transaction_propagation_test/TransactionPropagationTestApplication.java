package it.alessandro.test.transaction_propagation_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TransactionPropagationTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionPropagationTestApplication.class, args);
	}

}
