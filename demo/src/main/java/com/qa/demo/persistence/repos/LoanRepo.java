package com.qa.demo.persistence.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.persistence.domain.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {
    List<Loan> findBylibId(Long libId);
}
