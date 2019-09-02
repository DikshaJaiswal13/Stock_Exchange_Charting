package com.example.stockspring.controller;

import java.sql.SQLException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.stockspring.SendEmail;
import com.example.stockspring.model.Company;
import com.example.stockspring.model.IpoPlanned;
import com.example.stockspring.model.Login;
import com.example.stockspring.model.Otp;
import com.example.stockspring.model.User;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.UserService;
import com.example.stockspring.service.UserServiceImpl;

@Controller
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService userService=new UserServiceImpl();
	
	@Autowired
	private CompanyService companyService;

	User user=new User();
	SendEmail sendMail=new SendEmail();
	int otp1=0;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(ModelMap model) throws SQLException {
		System.out.println("inside get login");

		//e.setEmail("sdfsf");
		//	e.setSalary(4564.56f);
		//String l="login";
		model.addAttribute("l1", user);
		//if(user !=null) {
		//	l="redirect:/loginAgain";
			//session.setAttribute("currentlogin",user);
		//}
			
		//model.addAttribute("sectorList", companyService.getSectorList());
		return "login";

	}
	
	/*
	 * @RequestMapping(value="/loginAgain") public String loginAgain(ModelMap model)
	 * { return "login"; }
	 */


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLogin(@Valid User user, 
			BindingResult result, Model model, HttpSession session) throws SQLException {
		System.out.println("inside post login");
		//user.setUsertype("admin");
		//System.out.println(user);
		/*
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("l1", user);
			return "redirect:/login";
		}*/
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		User u=new User();
		u=userService.login(user.getUsername(),user.getPassword());
		//model.addAttribute("name", employee.getName());
		System.out.println(u);
		/*	if((user.getUsername()==u.getUsername()) && (user.getPassword()==u.getPassword()))*/
		if(u!=null) {
			if(u.getPassword().equals(user.getPassword()))
				//session.setAttribute("user", u);
			{
				System.out.println("good credentials");
				System.out.println(u.getEmail());
				session.setAttribute("user", u);
				if(u.getUsertype().equals("admin"))
				return "redirect:/adminLandingPage";
				else
					return "redirect:/userLandingPage";

			}
			else
				return "redirect:/login";
		}
		else
			//JOptionPane.showMessageDialog(null, "message");
			return "redirect:/login";
	}


	@RequestMapping(value = "/register", method = RequestMethod.GET) 
	public String getRegister(ModelMap model) throws SQLException {
		//System.out.println("add company"); 
		User user=new User();
		//e.setEmail("sdfsf"); // e.setSalary(4564.56f);

		model.addAttribute("r1", user);

		//model.addAttribute("sectorList", companyService.getSectorList()); 
		return "register";

	}

	User u=new User();

	@RequestMapping(value = "/register1", method = RequestMethod.POST)
	public String adminLogin(@Valid User user, 
			BindingResult result, Model model) throws SQLException {
		System.out.println("inside post admin register");
		/*if(user.getUsername()==null || user.)
			return "redirect:/register";
		else {*/
		user.setUsertype("admin");
		user.setConfirmed(1);
		
		System.out.println(user);
		u.setConfirmed(user.getConfirmed());
		u.setEmail(user.getEmail());
		u.setMobilenumber(user.getMobilenumber());
		u.setUsername(user.getUsername());
		u.setUsertype(user.getUsertype());
		u.setPassword(user.getPassword());
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("r1", user);
			return "redirect:/register";
		}
		//userService.insertUser(user);
		//call
		/*else {*/
		otp1=sendMail.sendMail(user.getEmail());
		
		return "redirect:/otpController";
		
	}
	

	@RequestMapping(value = "/register2", method = RequestMethod.POST)
	public String userLogin(@Valid User user, 
			BindingResult result, Model model) throws SQLException {
	/*	System.out.println("inside post user register");
		user.setUsertype("user");
		System.out.println(user);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("r1", user);
			return "redirect:/register";
		}
		userService.insertUser(user);
		//model.addAttribute("name", employee.getName());
		return "redirect:/login";*/
		
		
		System.out.println("inside post user register");

		user.setUsertype("user");
		user.setConfirmed(1);
		
		System.out.println(user);
		u.setConfirmed(user.getConfirmed());
		u.setEmail(user.getEmail());
		u.setMobilenumber(user.getMobilenumber());
		u.setUsername(user.getUsername());
		u.setUsertype(user.getUsertype());
		u.setPassword(user.getPassword());
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("r1", user);
			return "redirect:/register";
		}
		//userService.insertUser(user);
		//call

		otp1=sendMail.sendMail(user.getEmail());
		
		return "redirect:/otpController";
		
	}


	@RequestMapping(value = "/otpController", method = RequestMethod.GET)
	public String getOtpPage(ModelMap model) throws SQLException {
		Otp adminOtp=new Otp();
		model.addAttribute("c1", adminOtp);

		return "otpPage";

	}

	@RequestMapping(value = "/otpController", method = RequestMethod.POST)
	public String postOtpPage(@Valid Otp adminOtp, 
			BindingResult result, Model model) throws SQLException {
		System.out.println("inside post admin otp");

		//user.setUsertype("admin");
		System.out.println(adminOtp);

		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("c1", adminOtp);
			return "redirect:/otpController";
		}
		
		System.out.println();

		if(otp1==adminOtp.getOtpVerification()) {

			if(userService.insertUser(u) && u.getUsertype().equals("admin"))
				return "redirect:/adminLandingPage";
			else
				return "redirect:/userLandingPage";
		}
		else
			return "redirect:/otpController";
		//return "redirect:/adminLandingPage";
		
		//return "redirect:/otpController";
	}

	@RequestMapping(value = "/adminLandingPage", method = RequestMethod.GET)
	public String getAdminLandingPage(ModelMap model) throws SQLException {

		return "adminLandingPage";

	}

	
	@RequestMapping(value = "/userLandingPage", method = RequestMethod.GET)
	public String getUserLandingPage(ModelMap model) throws SQLException {

		return "userLandingPage";

	}
	
	
	
	/*@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String resetpassword(ModelMap model) throws SQLException {
		ResetPassword u=new ResetPassword();
		model.addAttribute("e1", u);
		return "ResetPassword";

	}
	
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String reset(@Valid ResetPassword resetPassword ,ModelMap model) throws SQLException {
		Login login=new Login();
		login.setUsername(resetPassword.getUname());
		login.setPassword(resetPassword.getOldpass());
		User user=userService.loginUser(login);
		user.setPassword(resetPassword.getNewpass());
		userService.registerUser(user);
		return "redirect:/resetPassword";

	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/resPas", method = RequestMethod.GET)
	public String userForgotPasswordCall(ModelMap model) {
		User u1=new User();
	 model.addAttribute("resetPass", u1);
	 return "resPas";
	}
	
	 String a = "";
	 String b = "";
	
	 
	 
	/* @RequestMapping(value ="/forgotpassword/{companyId}", method=RequestMethod.GET)
		public String goEditCompany(@PathVariable("companyId") int companyId, ModelMap model) throws SQLException {
			Company co=null;
			co=(Company)companyService.getCompanyById(companyId);
			System.out.println(co.getBoardOfDirectors());
			model.addAttribute("currentcompany1", co);
			model.addAttribute("sectorList", companyService.getSectorList());
			return "editCompany";
		}*/
	 
	 
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	/*public String verifyForgotPassword(@ModelAttribute("pass") Admin user, Model model, HttpServletRequest request,
	  HttpServletResponse response) {*/
	public String verifyForgotPassword(@Valid User user2, 
			BindingResult result, Model model) throws SQLException {
	 System.err.println("Inside forgotpassword Verification Controller");
		/* User dbUser = userService.findById(user.getEmail()); */
	 
	// model.addAttribute("pass",)
	 
	 User dbUser=new User();
	 dbUser=userService.validEmail(user2.getEmail());
	 int loginStatus = 0;
	 //String a = "";
	// String b = "";
	 String url = null;
	 if (dbUser != null) {
	  if (dbUser.getEmail() != null) {

	   loginStatus = 1; // HINT ANSWER MATCHED
	  } else {
	   loginStatus = -2; // HINT ANSWER mismatch
	  }
	 }
	 if (loginStatus == 1) {
	  a = dbUser.getPassword();
	  b = dbUser.getEmail();
	  url = "password/"+b;
	  //model.addAttribute("pass", dbUser);
	 } else {
	  url = "resPas";
	 }
	 model.addAttribute("a", a);
	 model.addAttribute("b", b);
	 System.err.println("LoginStatus= " + loginStatus);
	 model.addAttribute("loginStatus", loginStatus);
	 model.addAttribute("resetPass", new User());
	 // request.getSession().setAttribute("loginStatus", loginStatus);
	 return "redirect:/"+url;
	}
	
	@RequestMapping(value = "/password/{b}", method = RequestMethod.GET)
	public String getuserForgotPasswordCall(@PathVariable("b") String email, ModelMap model) {
		User u2=null;
		u2=(User)userService.validEmail(email);
	 model.addAttribute("pass", u2);
	 
 
	 
	/* Company co=null;
		co=(Company)companyService.getCompanyById(companyId);
		System.out.println(co.getBoardOfDirectors());
		model.addAttribute("currentcompany1", co);*/
	 
	 
	 
	 return "password";
	}
	
	

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	/*public String newPassword(@ModelAttribute("admin") Admin user, Model model, HttpServletRequest request,
	  HttpServletResponse response) {*/
	public String newPassword(@Valid User user1, 
			BindingResult result, Model model) throws SQLException {
	 System.err.println("Inside forgotpassword Verification Controller");
	 System.out.println("_--------------------------" + user);
	 User dbUser = userService.validEmail(user1.getEmail());
	 
	// model.addAttribute("pass", dbUser);
	 
	 System.out.println(dbUser + "-----------------------------------------------------------------");
	 // String a="";
	
	 String url = "redirect:/login";
	 dbUser.setPassword(user1.getPassword()); // PASSWORD CHANGING
	 userService.updatePassword(dbUser);
	 System.out.println("_----------========----------------" + dbUser);
	 int loginStatus = 1;
	 return url;
	}
	
	
	@RequestMapping(value = "/checkAdminid")
	@ResponseBody
	public String checkAdminid(@RequestParam String admin) {
		System.out.println("=========================check email controller=====================");

		if (userService.checkAdminid(admin)) {
			return "Username is Available";
		} else
			return "Username is taken";
	}
	
	@RequestMapping(value = "/checkValidation")
	@ResponseBody
	public String checkValidation(@RequestParam String uname, String pass) throws SQLException {
		System.out.println("=========================check Validation=====================");
		System.out.println("Password==============="+pass);
		Login login=new Login();
		login.setUsername(uname);
		login.setPassword(pass);
		User user=userService.loginUser(login);
		if(user!=null && user.getPassword().equals(login.getPassword()))
			return "Right";
		else
			return "Wrong";
	}

	@RequestMapping(value = "/comparecompany", method = RequestMethod.GET)
	public String getCompareCompany(ModelMap model) throws SQLException {
		IpoPlanned ipo=new IpoPlanned();
		model.addAttribute("c1",ipo);
		model.addAttribute("companyList", companyService.getCompanyList());
		return "compareCompany";

	}
	
	@RequestMapping(value = "/showgraph", method = RequestMethod.POST)
	public String getShowGraph(ModelMap model) throws SQLException {

		return "graph";

	}
	
	

}



