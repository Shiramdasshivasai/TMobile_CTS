package com.cts.project.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.stereotype.Service;

import com.cts.project.springboot.model.Employee;
@Service
public class EmployeeService {
	private static List<Employee> list=new ArrayList<Employee>();
	static
	{
		Employee Shiva=(new Employee("Shiva", 1, "hyderabad"));
		Employee Raghu=(new Employee("raghu", 2, "banglore"));
		list.add(Shiva);
		list.add(Raghu);
	}
	public List<Employee> retrieveAll()
	{
		return list;
	}
	
	public Employee getEmployeeDetails(long id)
	{
		for(Employee e:list)
		{
			if(e.getId()==id)
			{
				return e;
			}
		}
		return null;
	}
	
	public void addEmployee(String name,long id,String address)
	{
		Employee em=new Employee(name,id,address);
		list.add(em);
	}
}
