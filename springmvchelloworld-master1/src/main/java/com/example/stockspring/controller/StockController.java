package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Stock;

public interface StockController {
	
	public String getimportStockPage(ModelMap model) throws SQLException;
	
	public ModelAndView getStockList() throws Exception;
	public String formHandler(@Valid Stock stock, 
			BindingResult result, Model model) throws SQLException;

}
