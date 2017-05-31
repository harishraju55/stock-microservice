package com.tek.repository;

import org.springframework.data.repository.CrudRepository;
import com.tek.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {

	
	public Stock findBySymbol(String symbol);
	
}
