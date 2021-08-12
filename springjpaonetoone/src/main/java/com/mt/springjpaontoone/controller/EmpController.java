package com.mt.springjpaontoone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.springjpaonetoone.entities.Address;
import com.mt.springjpaonetoone.entities.Employee;
import com.mt.springjpaontoone.dao.EmpRepository;

@RestController
public class EmpController {
	
	@Autowired
	public EmpRepository empRepo;
	
	@GetMapping("/emp/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id)
	{
		Employee emp=empRepo.findById(id).get();
		return emp;
	}
	
	@GetMapping("/emps")
	public List<Employee> getAllEmp()
	{
		List<Employee> empList=new ArrayList<Employee>();
		Iterable<Employee> itr=empRepo.findAll();
		for(Employee e:itr)
		{
			empList.add(e);
		}
		return empList;
	}
	@PostMapping("/emp/{addressId}")
	public Employee createAddress(@PathVariable("addressId") int addressId,@RequestBody Employee emp)
	{
		Address add=empRepo.getStudent(addressId);
		emp.setAdd(add);
		empRepo.save(emp);
		return getEmployeeById(emp.getId());
	}
	@DeleteMapping("/emp/{id}")
	public List<Employee> deleteEployee(@PathVariable("id") int id)
	{
		empRepo.deleteById(id);
		return getAllEmp();
	}
}
//	@Autowired
//	EmpService empService;
//	
//	@RequestMapping(value="/all")
//	public List<Employee> getAllEmp()
//	{
//		return this.empService.getAllEmp();
//	}
//	
//	@RequestMapping(value="/addemp",method = RequestMethod.POST,
//			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Employee addEmployee(@RequestBody Employee emp)
//	{
//		return this.empService.addEmployee(emp);
//	}
//	
//	@RequestMapping(value="/{id}",method = RequestMethod.GET)
//	public Optional<Employee> getEmployee(@PathVariable int id)
//	{
//		return this.empService.getEmployeeById(id);
//	}
//	
//	@RequestMapping(value="/updateemp",method=RequestMethod.PUT,
//			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Employee updateEmployee(@RequestBody Employee emp)
//	{
//		return this.empService.updateEmployee(emp);
//	}
//	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public void deleteEmployee(@PathVariable int id)
//	{
//		this.empService.deleteEmployeeById(id);
//	}
//	 @RequestMapping(value = "/all", method = RequestMethod.DELETE)
//	 public void deleteAllEmp()
//	 {
//		 this.empService.deleteAllEmp();
//	 }
	


