package com.example.stockspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stockspring.model.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> {
	 /* public boolean insertCompany(Company company) throws SQLException;
	    public Company updateCompany(Company company);
		public List<Company> getCompanyList() throws SQLException;
		public List<Sector> getSectorList() throws SQLException;*/
}
