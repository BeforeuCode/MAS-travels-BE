package com.mas.travels.repositories;

import com.mas.travels.models.employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Set<Employee> findAll();
}
