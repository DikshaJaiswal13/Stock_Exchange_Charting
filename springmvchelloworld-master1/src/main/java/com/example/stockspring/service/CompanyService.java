package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.Sector;

public interface CompanyService {

	
	  public Company insertCompany(Company company) throws SQLException;
	    public Company updateCompany(Company company);
		public List<Company> getCompanyList() throws SQLException;
		public List<Sector> getSectorList() throws SQLException;
		public Company deleteCompany(int companyId)throws SQLException;
		public Company getCompanyById(int companyId);
		

}
