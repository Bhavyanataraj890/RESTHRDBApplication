package Org.Bhavya.HRApplication.HRApp.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Org.Bhavya.HRApplication.HRApp.Model.Contact;
import Org.Bhavya.HRApplication.HRApp.Model.Employee;
import Org.Bhavya.HRApplication.HRApp.Service.EmployeeService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

//@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RestController
@RequestMapping("/HRApp/employees")
public class EmployeeResources {
	@Autowired
	EmployeeService eService;
	@Autowired
	HttpServletRequest request;
	
	@GetMapping
	//public List<Employee> getEmployee(@Context UriInfo uriInfo)
	public List<Employee> getEmployee()
	{
				List<Employee> emp = eService.getAllEmployees();
				StringBuffer url = request.getRequestURL();
				for(Employee e : emp)
				{
				e.addLink(url, "self");
				}
				
				return emp;
	}
	
	@GetMapping("/Specific")
	public Map<String, Contact> getEmployeeSpec()
	{
		return eService.getSpecifcEmployees();
	}	

	@GetMapping("/{empId}")
	public Employee getEmployee(@PathVariable("empId") String empId)
	{
		
		Employee emp = eService.getEmployee(empId);
		/*String url = uriInfo
		.getBaseUriBuilder()
		.path(EmployeeResources.class)
		.path(emp.getEmpId())
		.build()
		.toString();*/
		StringBuffer url = request.getRequestURL();
		emp.addLink(url, "self");
		return emp;
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return eService.addEmployee(emp);
	}
	

//	@PutMapping("/{empId}")
	@RequestMapping(
			  value = "/{empId}", 
			  method = RequestMethod.PUT)
	@ResponseBody
	public Employee updateEmployee(@PathVariable("empId") String empId, @RequestBody Employee emp)
	{
		emp.setEmpId(empId);
		return eService.updateEmployee(emp);
	}
	
	

	@RequestMapping(
			  value = "/{empId}", 
			  method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("empId") String empId)
	{
		eService.removeEmployee(empId);	
	}
	
	
}
