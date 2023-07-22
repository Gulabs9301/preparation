package com.onesoft.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empdao;

	public String addEmployee(Employee e) throws EmployeeException {
		try {
			if (e.getAge() < 18) {
				throw new EmployeeException("Not allowed");
			}

			else {
				return empdao.addEmployee(e);
			}
		} catch (EmployeeException ee) {
			return "Not allowed";
		}
		// TODO: handle exception

	}

	public String addAllEmployee(@RequestBody List<Employee> e) {
		return empdao.addAllEmployee(e);

	}

	public Employee findById(@PathVariable int id) {
		return empdao.findById(id);
	}

	public List<Employee> findall() {
		return empdao.findall();
	}

	public String deleteById(int id) {
		return empdao.deleteById(id);
	}

	public String updateEmployee(@RequestBody Employee e) {
		return empdao.updateEmployee(e);
	}

	public List<Employee> getEmployeeByName(String name) {
		List<Employee> d = empdao.findall();
		return d.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	public List<Employee> getbelowEmployeeDetails(int salary) {
		List<Employee> belowSalary = empdao.findall();
		return belowSalary.stream().filter(x -> x.getSalary() < salary).collect(Collectors.toList());
	}

	public List<Employee> getbelowAgeEmployeeDetails(int age) {
		List<Employee> belowAge = empdao.findall();
		return belowAge.stream().filter(x -> x.getAge() < age).collect(Collectors.toList());
	}

	public List<Employee> getEmployeeGenderDetails(String gender) {
		List<Employee> getgender = empdao.findall();
		return getgender.stream().filter(x -> x.getGender().equals(gender)).collect(Collectors.toList());
	}

	int max = 0;

	public int getEmployeeMaxSalary() {
		List<Employee> maxSalary = empdao.findall();
		maxSalary.forEach(x -> {
			if (x.getSalary() > max) {
				max = x.getSalary();
			}
		});
		return max;
	}

	int min = Integer.MAX_VALUE;

	public List<String> getEmployeeMinSalary() {
		List<Employee> minSalary = empdao.findall();
		minSalary.forEach(x -> {
			if (x.getSalary() < min) {
				min = x.getSalary();
			}
		});
		ArrayList<Employee> empWithMinSalary = new ArrayList<>();
		minSalary.forEach(x -> {
			if (x.getSalary() == min) {
				empWithMinSalary.add(x);
			}

		});
		return empWithMinSalary.stream().map(x -> x.getName()).collect(Collectors.toList());

	}

	int maxage = Integer.MIN_VALUE;

	public List<Integer> getEmployeeMaxAge() {
		List<Employee> maxAge = empdao.findall();
		maxAge.forEach(x -> {
			if (x.getAge() > maxage) {
				maxage = x.getAge();
			}
		});
		ArrayList<Employee> empWithMaxAge = new ArrayList<>();
		maxAge.forEach(x -> {
			if (x.getAge() == maxage) {
				empWithMaxAge.add(x);
			}

		});
		return empWithMaxAge.stream().map(x -> x.getSalary()).collect(Collectors.toList());

	}

	int minage = Integer.MAX_VALUE;

	public List<Integer> getEmployeeMinAge() {
		List<Employee> minAge = empdao.findall();
		minAge.forEach(x -> {
			if (x.getAge() < minage) {
				minage = x.getAge();
			}
		});
		ArrayList<Employee> empWithMinAge = new ArrayList<>();
		minAge.forEach(x -> {
			if (x.getAge() == minage) {
				empWithMinAge.add(x);
			}

		});
		return empWithMinAge.stream().map(x -> x.getId()).collect(Collectors.toList());

	}

	int a1 = 0;
	int b1 = 0;

	public List<Integer> getEmployeeSecondMax() {

		List<Employee> secondMax = empdao.findall();
		secondMax.forEach(x -> {
			if (x.getSalary() > a1) {
				b1 = a1;
				a1 = x.getSalary();
			} else if (x.getSalary() > b1 && x.getSalary() != a1) {
				b1 = x.getSalary();
			}
		});
		ArrayList<Employee> empWithSecondMax = new ArrayList<>();
		secondMax.forEach(x -> {
			if (x.getSalary() == b1) {
				empWithSecondMax.add(x);
			}

		});
		return empWithSecondMax.stream().map(x -> x.getId()).collect(Collectors.toList());

	}

	public List<Employee> getBySalary(int salary) {
		return empdao.getBySalary(salary);
	}

	public String updatename(Employee emp, int a) {
		Employee eee = empdao.findById(a);
		emp.setAge(eee.getAge());
		emp.setId(eee.getId());
		emp.setGender(eee.getGender());
		emp.setSalary(eee.getSalary());
		return empdao.updatename(emp);
	}

	public List<Employee> FindName(String name) throws EmployeeNameException, Exception {
		List<Employee> empall = empdao.findall();
		List<Employee> temp = empall.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
		if (temp.isEmpty()) {
			throw new EmployeeNameException("Name not Found");
		} else {
			return temp;
		}
	}

	public Employee modifyById(int id, Employee e) {
		return empdao.modifyById(id, e);
	}

}