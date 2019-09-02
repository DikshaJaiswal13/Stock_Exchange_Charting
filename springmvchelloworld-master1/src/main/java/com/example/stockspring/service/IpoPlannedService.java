package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.IpoPlanned;
import com.example.stockspring.model.Stock;


public interface IpoPlannedService {
	
	 public IpoPlanned insertIpo(IpoPlanned ipoplanned) throws SQLException;
	   // public Company updateCompany(Company company);
		public List<Company> getCompanyList() throws SQLException;
		public List<Stock> getStockList() throws SQLException;
		public List<IpoPlanned> getIpoList() throws SQLException;
}
