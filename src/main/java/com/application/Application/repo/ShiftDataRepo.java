package com.application.Application.repo;

import com.application.Application.model.ShiftData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftDataRepo extends JpaRepository<ShiftData, Long> {

}
