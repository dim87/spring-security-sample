package com.sda.angularhomeworkbackend.modules.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.angularhomeworkbackend.modules.auth.SecurityService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SecurityService securityService;

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
	public List<Employee> getAll() {
		final Long requestingUserId = securityService.getUserId();
		return employeeService.findAll();
	}

	@GetMapping(value = "/{employeeId}")
	public Employee getById(@PathVariable long employeeId) {
		return employeeService.findById(employeeId);
	}

	@PutMapping
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}

	@PatchMapping
	public Employee update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}

	@DeleteMapping(value = "/{employeeId}")
	public boolean deleteById(@PathVariable long employeeId) {
		return employeeService.delete(employeeId);
	}
}
