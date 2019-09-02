package com.example.stockspring.controller;


import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;
import com.example.stockspring.service.CompanyService;

@Controller
public class CompanyControllerImpl implements CompanyController{

	
	@Autowired
	private CompanyService companyService;
	
	
	
	
	@RequestMapping(value = "/addCompany", method = RequestMethod.GET)
	public String getAddCompany(ModelMap model) throws SQLException {
		System.out.println("add company");
		Company company=new Company();
		//e.setEmail("sdfsf");
	//	e.setSalary(4564.56f);
		 
		model.addAttribute("c1", company);
		model.addAttribute("sectorList", companyService.getSectorList());
		return "addCompany";
		
	}
	

	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout(ModelMap model,HttpSession session) throws SQLException {
		session.invalidate();
		return "logout";
		
	}
	
	
	
	
	
	
	@RequestMapping(path="/updateCompany")
	public ModelAndView getManageCompanyList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("updateCompanyPage");
		mv.addObject("companyList",companyService.getCompanyList());
		return mv;
	}
	
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public String formHandler(@Valid Company company, 
			BindingResult result, Model model) throws SQLException {
		System.out.println("inside post method");
		Random r = new Random();
		int num = r.nextInt(9000) + 1000;
		company.setCompanyId(num);
		System.out.println(company);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("c1", company);
			return "redirect:/addCompany";
		}
		//if(companyService.insertCompany(company)!=null)
			//model.addAttribute("name", employee.getName());
		companyService.insertCompany(company);
			return "redirect:/companyList";
		/*else
			return "redirect:/addCompany";*/
	
	}
	
	
	
	
	
	

	@RequestMapping(path="/companyList")
	public ModelAndView getCompanyList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("companyList");
		mv.addObject("companyList",companyService.getCompanyList());
		return mv;
	}
	
	
	// try
	/*
	 * public static void main(String [] args) { CompanyController controller=new
	 * CompanyControllerImpl(); try {
	 * System.out.println(controller.getCompanyList()); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
	
	@RequestMapping(value ="/editCompany/{companyId}", method=RequestMethod.GET)
	public String goEditCompany(@PathVariable("companyId") int companyId, ModelMap model) throws SQLException {
		Company co=null;
		co=(Company)companyService.getCompanyById(companyId);
		System.out.println(co.getBoardOfDirectors());
		model.addAttribute("currentcompany1", co);
		model.addAttribute("sectorList", companyService.getSectorList());
		return "editCompany";
	}
	
	
	@RequestMapping(value ="/editCompany/{companyId}", method=RequestMethod.POST)
	public String goPostEditCompany(@PathVariable("companyId") int companyId, ModelMap model, @Valid Company company) throws SQLException {
		
		
		companyService.updateCompany(company);
		
		return "redirect:/companyList";
	}
	
	
	
}
