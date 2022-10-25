package com.proyecto3.reportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto3.reportes.entity.employeDepartament;

@Repository
public interface EmployeeRepository extends JpaRepository<employeDepartament, Integer> {
    
}
