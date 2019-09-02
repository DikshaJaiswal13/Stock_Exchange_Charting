package com.example.stockspring.controller;

import java.sql.SQLException;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.Stock;
import com.example.stockspring.service.StockService;

@Controller
public class StockControllerImpl implements StockController{
	
	@Autowired
	private StockService stockService;
	

	@RequestMapping(value = "/importStock", method = RequestMethod.GET)
	public String getimportStockPage(ModelMap model) throws SQLException {
		System.out.println("add stock");
		Stock stock=new Stock();
		//e.setEmail("sdfsf");
	//	e.setSalary(4564.56f);
	
		model.addAttribute("istock", stock);
		//model.addAttribute("sectorList", stockService.getSList());
		return "importStockPage";
		
	}
	
	
	
	@RequestMapping(value = "/importStock", method = RequestMethod.POST)
	public String formHandler(@Valid Stock stock, 
			BindingResult result, Model model) throws SQLException {
		System.out.println("inside post addStock");
		Random r=new Random();
		  int no=r.nextInt(9000)+1000;
		 stock.setStockExchangeId(no);
		System.out.println(stock);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("istock", stock);
			return "redirect:/importStock";
		}
		stockService.insertStock(stock);
		//model.addAttribute("name", employee.getName());
		 return "redirect:/stockList";
	}
	


	@RequestMapping(path="/stockList")
	public ModelAndView getStockList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("stockDetailsPage");
		mv.addObject("stockList",stockService.getStockList());
		return mv;
	}



}
