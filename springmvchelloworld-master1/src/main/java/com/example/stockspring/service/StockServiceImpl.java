package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.stockspring.dao.StockDao;
import com.example.stockspring.model.Stock;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockDao stockDao;

	@Override
	public Stock insertStock(Stock stock) throws SQLException {
		// TODO Auto-generated method stub
		 //stockDao.insertStock(stock);
		return stockDao.save(stock);
		 //return null;
	}

	@Override
	public List<Stock> getStockList() throws SQLException {
		// TODO Auto-generated method stub
		//return stockDao.getStockList();
		return stockDao.findAll();
	}

}
