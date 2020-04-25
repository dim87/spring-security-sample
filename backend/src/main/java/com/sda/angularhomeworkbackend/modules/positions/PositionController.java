package com.sda.angularhomeworkbackend.modules.positions;

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
@RequestMapping("/positions")
public class PositionController {

	@Autowired
	private PositionService positionService;

	@GetMapping
	public List<Position> getAllDepartments() {
		return positionService.findAll();
	}

	@GetMapping(value = "/{positionId}")
	public Position getById(@PathVariable long positionId) {
		return positionService.findById(positionId);
	}

	@PutMapping
	public Position create(@RequestBody Position position) {
		return positionService.create(position);
	}

	@PatchMapping
	public Position update(@RequestBody Position position) {
		return positionService.update(position);
	}

	@DeleteMapping(value = "/{positionId}")
	public boolean deleteById(@PathVariable long positionId) {
		return positionService.delete(positionId);
	}
}
