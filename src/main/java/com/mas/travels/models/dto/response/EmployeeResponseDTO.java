package com.mas.travels.models.dto.response;

import com.mas.travels.models.employee.*;
import lombok.Data;

import java.util.Set;

@Data
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String type;
    private Integer salary;
    private Integer workAmount;
    private String employment;
    private String contract;
    private Integer employeeRanking;
    private Integer bonus;
    private Set<String> languages;

    public EmployeeResponseDTO(Employee employee){
        id = employee.getId();
        name = employee.getName();
        lastName = employee.getLastName();
        email = employee.getEmail();
        phone = employee.getEmail();
        if(employee instanceof CustomerService) {
            type = "Custom Service";
            employeeRanking = ((CustomerService) employee).getEmployeeRanking();
        }
        if(employee instanceof Guide) {
            type = "Guide";
             languages = ((Guide) employee).getLanguages();
        }
        if(employee instanceof Manager) {
            type = "Manager";
            bonus = ((Manager) employee).getBonus();
        }
       salary = employee.getSalary();
         workAmount = employee.getWorkAmount();
        employment = employee.getEmployment().name();
        contract = employee.getContract();

    }
}
