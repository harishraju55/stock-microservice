package com.tek;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.tek.model.Stock;
import com.tek.repository.StockRepository;


@SpringBootApplication
//@EnableDiscoveryClient
public class StocksMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksMicroserviceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initData(StockRepository stockRepository) {
		return args -> {
			stockRepository.save(new Stock("Apple", "AAPL", 110.00));
			stockRepository.save(new Stock("Microsoft", "MSFT", 50.00));
			stockRepository.save(new Stock("Google", "GOOGL", 700.00));
			stockRepository.save(new Stock("Amazon", "AMZN", 900.00));
			stockRepository.save(new Stock("Tesla", "TSLA", 400.00));
			stockRepository.save(new Stock("Twitter", "TWTR", 100.00));
		};
	}
}
