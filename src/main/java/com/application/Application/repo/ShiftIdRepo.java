package com.application.Application.repo;

import com.application.Application.model.ShiftIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftIdRepo extends JpaRepository<ShiftIdentifier, Long> {

}
