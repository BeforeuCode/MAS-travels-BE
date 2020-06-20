package com.mas.travels.services;

import com.mas.travels.models.dto.request.AddEmployeeDTO;
import com.mas.travels.models.employee.Employee;
import com.mas.travels.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addNewEmployee(AddEmployeeDTO employeeDTO) throws Exception {
        Employee employee = Employee.createEmployee(employeeDTO);
        employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(employeeOptional.isPresent()){
            employeeRepository.deleteById(employeeId);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
