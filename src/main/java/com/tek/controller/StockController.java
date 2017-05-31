package com.tek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.tek.model.Stock;
import com.tek.repository.StockRepository;


@RestController
public class StockController {

		
	@Autowired
	private StockRepository stockRepository;
	
	@RequestMapping(value = "/stocks", method = RequestMethod.GET)
	public ResponseEntity<List<Stock>> getAllStocks() {
		System.out.println("======== stock service */stocks*=======");
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stocks/{symbol}", method = RequestMethod.GET)
	public ResponseEntity<Stock> getPrice(@PathVariable("symbol") String symbol) {
		System.out.println("======== stock service */stocks/{symbol}*=======");
		Stock stock = stockRepository.findBySymbol(symbol);
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}
	
}
