package com.application.Application.repo;

import com.application.Application.model.TankReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TankReadingRepo extends JpaRepository<TankReading, Long> {

}
