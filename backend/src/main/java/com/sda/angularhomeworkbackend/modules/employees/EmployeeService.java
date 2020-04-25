package com.sda.angularhomeworkbackend.modules.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Employee findById(final long departmentId) {
		return employeeRepository.findById(departmentId).orElseThrow(
				() -> new RuntimeException(String.format("Department with ID '%s' was not found", departmentId)));
	}

	@Transactional(rollbackFor = Exception.class)
	public Employee create(final Employee employee) {
		return employeeRepository.save(employee);
	}

	@Transactional(rollbackFor = Exception.class)
	public Employee update(final Employee employee) {
		return employeeRepository.save(employee);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean delete(final long departmentId) {
		employeeRepository.deleteById(departmentId);
		return true;
	}
}
