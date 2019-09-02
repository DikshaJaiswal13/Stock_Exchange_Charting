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
import com.example.stockspring.model.IpoPlanned;
import com.example.stockspring.model.Stock;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.IpoPlannedService;
import com.example.stockspring.service.StockService;

@Controller
public class IpoPlannedControllerImpl implements IpoPlannedController{
	
	@Autowired
	private IpoPlannedService ipoplannedService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private StockService stockService;
	
	
	@RequestMapping(value = "/ipoRegistration", method = RequestMethod.GET)
	public String getIpoRegPage(ModelMap model) throws SQLException {
		//System.out.println("add company");
		IpoPlanned ipoplanned=new IpoPlanned();
		//e.setEmail("sdfsf");
	//	e.setSalary(4564.56f);
	
		model.addAttribute("c1", ipoplanned);
		model.addAttribute("companyList", companyService.getCompanyList());
		model.addAttribute("stockList", stockService.getStockList());
		return "IPOregistration";
		
	}

	

	@RequestMapping(value = "/ipoRegistration", method = RequestMethod.POST)
	public String formHandler(@Valid IpoPlanned ipoplanned, 
			BindingResult result, Model model) throws SQLException {
				
		System.out.println("inside post ipoplanned");
		Random r=new Random();
		int no=r.nextInt(9000)+1000;
		ipoplanned.setId(no);
		System.out.println(ipoplanned);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("c1", ipoplanned);
			return "redirect:/ipoRegistration";
		}
		ipoplannedService.insertIpo(ipoplanned);
		//model.addAttribute("name", employee.getName());
		return "redirect:/adminLandingPage";
	}
	
	@RequestMapping(path="/ipoList")
	public ModelAndView getIpoList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ipoList");
		mv.addObject("ipoList",ipoplannedService.getIpoList());
		return mv;
	}
	
	/*@RequestMapping(value = "/ipoList", method = RequestMethod.GET)
	public String getAdminLandingPage(ModelMap model) throws SQLException {

		return "adminLandingPage";

	}*/

	
}

