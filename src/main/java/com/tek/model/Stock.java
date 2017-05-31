package com.tek.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table
public class Stock implements Serializable{

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	//@JsonProperty("Id")
	private long id;
	//@JsonProperty("Name")
	private String name;
	//@JsonProperty("Symbol")
	private String symbol;
	//@JsonProperty("Price")
	private double price;
	
	
	public Stock() {

	}

	
	

	public Stock(String name, String symbol, double price) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", symbol=" + symbol + ", price=" + price + "]";
	}
	
	
}
