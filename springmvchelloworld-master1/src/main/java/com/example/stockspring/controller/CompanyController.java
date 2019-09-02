package com.example.stockspring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.Sector;

public interface CompanyController {

	public String getAddCompany(ModelMap model) throws SQLException;
	//public Company updateCompany(Company company);
	public ModelAndView getCompanyList() throws Exception;
	public String formHandler(@Valid Company company, 
			BindingResult result, Model model) throws SQLException;

	
}
