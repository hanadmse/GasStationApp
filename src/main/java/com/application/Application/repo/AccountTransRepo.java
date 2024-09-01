package com.application.Application.repo;

import com.application.Application.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransRepo extends JpaRepository<AccountTransaction, Long> {
}
