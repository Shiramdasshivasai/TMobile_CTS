package com.cts.project.springboot.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.project.springboot.model.Employee;
import com.cts.project.springboot.service.EmployeeService;

@Controller
public class LoginController {
	@Autowired
	Employee employee;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/login")
	public String Shiva(@RequestParam String name,ModelMap model)
	{
		model.put("name", name);
		return "login";
	}
	
	/*
	 * @GetMapping("/login") public String Show(@RequestParam String username) {
	 * return "hii"+username; }
	 */
	
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public String showForm(ModelMap model)
	{
		model.put("employee", employeeService.retrieveAll());
		return "showemp";
	}
	
	@GetMapping("/getemp")
	public String GetEmployee(@RequestParam long id,ModelMap model)
	{
		Employee e=employeeService.getEmployeeDetails(id);
		if(e==null)
		{
			return "emperror";
		}
		else
		{
		model.put("employee",e);
		return "getemp";
		}
	}
	
	@RequestMapping(value="/addemployee",method=RequestMethod.GET)
	public String showFormToAdd(@RequestParam String name,@RequestParam long id,@RequestParam String address)
	{
		employeeService.addEmployee(name,id,address);
		return "success";
	}
	
}
