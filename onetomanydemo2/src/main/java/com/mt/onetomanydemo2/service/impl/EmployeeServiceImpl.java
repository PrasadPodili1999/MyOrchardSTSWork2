package com.mt.onetomanydemo2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.onetomanydemo2.exceptionhandler.EmployeeNotFoundExcepion;
import com.mt.onetomanydemo2.model.Department;
import com.mt.onetomanydemo2.model.Employee;
import com.mt.onetomanydemo2.repository.DeptRepository;
import com.mt.onetomanydemo2.repository.EmployeeRepository;
import com.mt.onetomanydemo2.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	DeptRepository deptRepo;

	public Employee addEmployee(Employee emp) {
//		Department dept = deptRepo.findById(emp.getDept().getId()).orElse(null);
//		if (dept == null) {
//			dept = new Department();
//		}
//		dept.setName(emp.getDept().getName());
//		emp.setDept(dept);
		return empRepo.save(emp);
	}

	public List<Employee> getAllEmployee() {
		Iterable<Employee> itr = empRepo.findAll();
		List<Employee> empList = new ArrayList<Employee>();
		for (Employee e : itr) {
			empList.add(e);
		}
		return empList.stream().sorted().map(m -> m).collect(Collectors.toList());
	}

	public Employee getEmpById(int id) throws EmployeeNotFoundExcepion {
		Employee emp = empRepo.findById(id).orElse(null);
		if (emp == null) {
			throw new EmployeeNotFoundExcepion();
		}
		return emp;

	}

	public Employee editEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	public void deleteAllEmployee() throws EmployeeNotFoundExcepion {

		if (!getAllEmployee().isEmpty()) {
			empRepo.deleteAll();
		} else {
			throw new EmployeeNotFoundExcepion();
		}
	}

	public void deleteEmpById(int id) throws EmployeeNotFoundExcepion {
		Employee emp = getEmpById(id);
		if (emp != null) {
			empRepo.deleteById(id);
		} else {
			throw new EmployeeNotFoundExcepion();
		}
	}

}
