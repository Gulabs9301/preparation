package com.onesoft.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empr;

	public String addEmployee(Employee e) {
		empr.save(e);
		return "SuccessFully updated";
	}

	public String addAllEmployee(List<Employee> e) {
		empr.saveAll(e);
		return "Successfully updated";

	}

	public Employee findById(int id) {

		return empr.findById(id).get();
	}

	public List<Employee> findall() {
		return empr.findAll();
	}

	public String deleteById(int id) {
		empr.deleteById(id);
		return "SucssFully deleted";
	}

	public String updateEmployee(@RequestBody Employee e) {
		empr.save(e);
		return "Succesfully updated";
	}

	public List<Employee> getBySalary(int salary) {
		return empr.getBySalary(salary);
	}

	public String updatename(Employee emp) {
		empr.save(emp);
		return "Successfully Name Updated";
	}

	public Employee modifyById(int id, Employee e) {
		Employee a = empr.findById(id).get();
		a.setAge(e.getAge());
		return a; 

	}

}
