package com.example.stockspring.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.stockspring.model.Stock;

public interface StockDao extends JpaRepository<Stock, Integer> {

	 /* public boolean insertStock(Stock stock) throws SQLException;
	    
		public List<Stock> getStockList() throws SQLException; */

}
