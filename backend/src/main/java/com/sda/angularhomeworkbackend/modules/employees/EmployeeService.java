package com.sda.angularhomeworkbackend.modules.employees;

import java.util.List;

import org.apache.commons.lang3.Validate;
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
		Validate.isTrue(employee.getId() == null, "id most not be defined when creating record for '%s'", employee);
		validateEmployeeRecord(employee);
		return employeeRepository.save(employee);
	}

	@Transactional(rollbackFor = Exception.class)
	public Employee update(final Employee employee) {
		Validate.notNull(employee.getId(), "id is null for '%s'", employee);
		validateEmployeeRecord(employee);
		return employeeRepository.save(employee);
	}

	private void validateEmployeeRecord(final Employee employee) {
		Validate.notBlank(employee.getFirstName(), "firstName is blank for '%s'", employee);
		Validate.notBlank(employee.getLastName(), "lastName is blank for '%s'", employee);
		Validate.notBlank(employee.getEmail(), "email is blank for '%s'", employee);
		Validate.notNull(employee.getDepartmentId(), "departmentId is null for '%s'", employee);
		Validate.notNull(employee.getPositionId(), "positionId is null for '%s'", employee);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean delete(final long departmentId) {
		employeeRepository.deleteById(departmentId);
		return true;
	}
}
