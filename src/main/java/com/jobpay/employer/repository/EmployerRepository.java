package com.jobpay.employer.repository;

import com.jobpay.employer.models.Employer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Optional<Employer> findByName(Employer name);
    Optional<Employer> findByIdentification(Integer identification);
    Boolean existsByIdentification(Integer identification);
    List<Employer> findAll(Specification<Employer> spec);
}