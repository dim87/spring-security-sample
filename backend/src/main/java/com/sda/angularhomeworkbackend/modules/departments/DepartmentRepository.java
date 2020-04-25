package com.sda.angularhomeworkbackend.modules.departments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DepartmentRepository extends JpaRepository<Department, Long> {

}
