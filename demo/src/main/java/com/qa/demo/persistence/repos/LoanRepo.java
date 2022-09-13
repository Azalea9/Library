package com.qa.demo.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.persistence.domain.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {
    Loan findBylibId(Long libId);
}
