package com.application.Application.repo;

import com.application.Application.model.Nozzle;
import com.application.Application.model.Tank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TankRepo extends JpaRepository<Tank, Long> {
}
