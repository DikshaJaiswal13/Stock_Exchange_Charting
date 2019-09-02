package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;


import com.example.stockspring.model.Stock;

public interface StockService {

	
	  public Stock insertStock(Stock stock) throws SQLException;
	    public List<Stock> getStockList() throws SQLException;
		

}
