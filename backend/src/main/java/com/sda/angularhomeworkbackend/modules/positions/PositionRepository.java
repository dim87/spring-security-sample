package com.sda.angularhomeworkbackend.modules.positions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PositionRepository extends JpaRepository<Position, Long> {

}
