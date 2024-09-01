package com.application.Application.repo;

import com.application.Application.model.Nozzle;
import com.application.Application.model.NozzleReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NozzleRepo extends JpaRepository<Nozzle, Long> {
}
