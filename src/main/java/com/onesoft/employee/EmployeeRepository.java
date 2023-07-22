package com.onesoft.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "select*from employee_details where salary>?", nativeQuery = true)

	public List<Employee> getBySalary(int salary);
}
