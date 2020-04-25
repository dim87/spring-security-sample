package com.sda.angularhomeworkbackend.modules.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Transactional(readOnly = true)
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Department findById(final long departmentId) {
		return departmentRepository.findById(departmentId).orElseThrow(
				() -> new RuntimeException(String.format("Department with ID '%s' was not found", departmentId)));
	}

	@Transactional(rollbackFor = Exception.class)
	public Department create(final Department department) {
		return departmentRepository.save(department);
	}

	@Transactional(rollbackFor = Exception.class)
	public Department update(final Department department) {
		return departmentRepository.save(department);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean delete(final long departmentId) {
		departmentRepository.deleteById(departmentId);
		return true;
	}
}
