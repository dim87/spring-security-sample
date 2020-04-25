package com.sda.angularhomeworkbackend.modules.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.findAll();
	}

	@GetMapping(value = "/{departmentId}")
	public Department getDepartmentById(@PathVariable long departmentId) {
		return departmentService.findById(departmentId);
	}

	@PutMapping
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.create(department);
	}

	@PatchMapping
	public Department updateDepartment(@RequestBody Department department) {
		return departmentService.update(department);
	}

	@DeleteMapping(value = "/{departmentId}")
	public boolean deleteById(@PathVariable long departmentId) {
		return departmentService.delete(departmentId);
	}
}
