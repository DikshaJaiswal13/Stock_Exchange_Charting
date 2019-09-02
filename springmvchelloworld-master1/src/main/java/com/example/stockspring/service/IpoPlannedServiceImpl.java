package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.CompanyDao;
import com.example.stockspring.dao.IpoPlannedDao;

import com.example.stockspring.dao.StockDao;
import com.example.stockspring.model.Company;
import com.example.stockspring.model.IpoPlanned;
import com.example.stockspring.model.Stock;

@Service
public class IpoPlannedServiceImpl implements IpoPlannedService{

	
	@Autowired
	private IpoPlannedDao ipoplannedDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Override
	public IpoPlanned insertIpo(IpoPlanned ipoplanned) throws SQLException {
		
		return ipoplannedDao.save(ipoplanned);
	}

	@Override
	public List<Company> getCompanyList() throws SQLException {
		// TODO Auto-generated method stub
		return companyDao.findAll();
	}

	@Override
	public List<Stock> getStockList() throws SQLException {
		// TODO Auto-generated method stub
		return stockDao.findAll();
	}

	@Override
	public List<IpoPlanned> getIpoList() throws SQLException {
		// TODO Auto-generated method stub
		return ipoplannedDao.findAll();
	}

}
