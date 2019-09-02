package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.CompanyDao;
import com.example.stockspring.dao.SectorDao;
import com.example.stockspring.model.Company;
import com.example.stockspring.model.Sector;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private SectorDao sectorDao;
	
	@Override
	public Company insertCompany(Company company) throws SQLException {
		// TODO Auto-generated method stub
		
		return companyDao.save(company);
	}

	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDao.save(company);
	}

	@Override
	public List<Company> getCompanyList() throws SQLException {
		//return companyDao.getCompanyList();
		return companyDao.findAll();
	}
	
	public List<Sector> getSectorList() throws SQLException{
		return sectorDao.findAll();
		//return companyDao.getSectorList();
		
	}

	@Override
	public Company deleteCompany(int companyId) throws SQLException {
		return null;
		// TODO Auto-generated method stub
		
		/* CompanyDao comp = companyDao.findAll(CompanyDao.class, companyId);
		 if(comp!= null)
		return companyDao.remove(comp);*/
	}

	@Override
	public Company getCompanyById(int companyId) {
		
		
		return companyDao.getOne(companyId);
	}

}
