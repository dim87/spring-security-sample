package com.sda.angularhomeworkbackend.modules.positions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class PositionService {

	@Autowired
	private PositionRepository positionRepository;

	@Transactional(readOnly = true)
	public List<Position> findAll() {
		return positionRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Position findById(final long departmentId) {
		return positionRepository.findById(departmentId).orElseThrow(
				() -> new RuntimeException(String.format("Department with ID '%s' was not found", departmentId)));
	}

	@Transactional(rollbackFor = Exception.class)
	public Position create(final Position position) {
		return positionRepository.save(position);
	}

	@Transactional(rollbackFor = Exception.class)
	public Position update(final Position position) {
		return positionRepository.save(position);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean delete(final long departmentId) {
		positionRepository.deleteById(departmentId);
		return true;
	}
}
