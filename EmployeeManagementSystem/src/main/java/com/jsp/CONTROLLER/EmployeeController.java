package com.jsp.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.DAO.EmployeeDao;
import com.jsp.DTO.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao dao;

	@RequestMapping("/insert")
	public ModelAndView getEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("create.jsp");
		return mv;
	}
	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee)
	{
		dao.saveEmployee(employee);
	    ModelAndView v=new ModelAndView();
	    v.setViewName("index.jsp");
		return v;
		
	}
	//API for searching an object in DB based on id
	@RequestMapping("/search")
	public ModelAndView searchEmployee()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("get.jsp");
		return mv;
		
	}
	@RequestMapping("/display")
	public ModelAndView findEmployee(@ModelAttribute Employee employee)
	{
		ModelAndView mv=new ModelAndView();
		Employee emp=dao.getEmployeeByID(employee.getId());
		mv.addObject("employee",emp);
		mv.setViewName("display.jsp");
		return mv;
		
	}
	@RequestMapping("/delete")
	public ModelAndView deleteEmployee()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("delete.jsp");
		return mv;
	}
	@RequestMapping("/remove")
	public ModelAndView removeEmployee(@ModelAttribute Employee employee)
	{
		ModelAndView mv=new ModelAndView();
		dao.deleteEmployee(employee.getId());
		mv.addObject("employee",new Employee());
		mv.setViewName("sucess.jsp");
		return mv;
//		return "REMOVED EMPLOYEE DETAILS SUCESSFULLY";
		

	}
	@RequestMapping("/displayall")
	public ModelAndView getAllEmployee()
	{
		ModelAndView mv=new ModelAndView();
		List<Employee> employees=dao.getAllEmployee();
		mv.addObject("employeelist",employees);
		mv.setViewName("displayAll.jsp");
		return mv;
	}
	//API to update employee
	@RequestMapping("/update")
	public ModelAndView updateEmployee()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("update.jsp");
		return mv;
	}
	@RequestMapping("/modify")
	public ModelAndView modifyEmployeeDetails(@ModelAttribute Employee employee)
	{
		ModelAndView mv=new ModelAndView();
		dao.updateEmployee(employee);
		mv.addObject("employee",new Employee());
		mv.setViewName("updated.jsp");
		return mv;
	}
	

}
