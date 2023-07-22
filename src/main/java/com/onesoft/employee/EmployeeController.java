package com.onesoft.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	EmployeeService emps;

	@PostMapping(value = "/insert")
	public String addEmployee(@RequestBody Employee e) throws EmployeeException {
		return emps.addEmployee(e);
	}

	@PostMapping(value = "/insertall")
	public String addAllEmployee(@RequestBody List<Employee> e) {
		return emps.addAllEmployee(e);

	}

	@GetMapping(value = "/getbyid/{id}")
	public Employee findById(@PathVariable int id) {
		return emps.findById(id);
	}

	@GetMapping(value = "/getall")
	public List<Employee> findall() {
		return emps.findall();
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return emps.deleteById(id);
	}

	@PutMapping(value = "/update/{e}")
	public String updateEmployee(@RequestBody Employee e) {
		return emps.updateEmployee(e);
	}

	@GetMapping(value = "/findname/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) {
		return emps.getEmployeeByName(name);
	}

	@GetMapping(value = "/getbelowdetails/{salary}")
	public List<Employee> getbelowEmployeeDetails(@PathVariable int salary) {
		return emps.getbelowEmployeeDetails(salary);
	}

	@GetMapping(value = "/getBelowAge/{age}")
	public List<Employee> getbelowAgeEmployeeDetails(@PathVariable int age) {
		return emps.getbelowAgeEmployeeDetails(age);
	}

	@GetMapping(value = "/getByGender/{gender}")
	public List<Employee> getEmployeeGenderDetails(@PathVariable String gender) {
		return emps.getEmployeeGenderDetails(gender);
	}

	@GetMapping(value = "/getMaxSalary")
	public int getEmployeeMaxSalary() {
		return emps.getEmployeeMaxSalary();
	}

	@GetMapping(value = "/getMinSalary")
	public List<String> getEmployeeMinSalary() {
		return emps.getEmployeeMinSalary();
	}

	@GetMapping(value = "/getMaxAgeSalary")
	public List<Integer> getEmployeeMaxAge() {
		return emps.getEmployeeMaxAge();
	}

	@GetMapping(value = "/getMinAgeId")
	public List<Integer> getEmployeeMinAge() {
		return emps.getEmployeeMinAge();
	}

	@GetMapping(value = "/getSecondMaxSalary")
	public List<Integer> getEmployeeSecondMax() {
		return emps.getEmployeeSecondMax();
	}

	@GetMapping(value = "/GetBySal/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return emps.getBySalary(salary);
	}

	@PostMapping("/updateOnlyname/{a}")
	public String updatename(@RequestBody Employee emp, @PathVariable int a) {
		return emps.updatename(emp, a);
	}

	@GetMapping(value = "/findName/{name}")
	public List<Employee> FindName(@PathVariable String name) throws EmployeeNameException, Exception {
		return emps.FindName(name);
	}
	@PatchMapping("/modify/{id}")
	public Employee modifyById(@PathVariable int id,@RequestBody Employee e) {
		return emps.modifyById(id,e);
	}

}
