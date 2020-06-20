package com.mas.travels.models.employee;

import com.mas.travels.models.common.Person;
import com.mas.travels.models.dto.request.AddEmployeeDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="employee_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Employee extends Person {
    private Integer salary;
    private static Integer minimalSalary = 2000;
    private Integer workAmount;
    @Enumerated(STRING)
    private EmploymentType employment;
    private String contract;

    public static Employee createEmployee(AddEmployeeDTO employeeDTO) throws Exception {
        switch (employeeDTO.getType()) {
            case "CUSTOMER_SERVICE":
                CustomerService customerService = CustomerService.builder()
                        .name(employeeDTO.getName())
                        .lastName(employeeDTO.getLastName())
                        .email(employeeDTO.getLastName())
                        .phone(employeeDTO.getPhone())
                        .salary(employeeDTO.getSalary())
                        .workAmount(employeeDTO.getWorkAmount())
                        .employment(EmploymentType.valueOf(employeeDTO.getEmployment()))
                        .build();
                if (customerService.getEmployment().equals(EmploymentType.FULL)) {
                    customerService.setContract(employeeDTO.getContract());
                }
                return customerService;
            case "GUIDE":
                Guide guide = Guide.builder()
                        .name(employeeDTO.getName())
                        .lastName(employeeDTO.getLastName())
                        .email(employeeDTO.getLastName())
                        .phone(employeeDTO.getPhone())
                        .salary(employeeDTO.getSalary())
                        .workAmount(employeeDTO.getWorkAmount())
                        .employment(EmploymentType.valueOf(employeeDTO.getEmployment()))
                        .languages(employeeDTO.getLanguages())
                        .build();
                if (guide.getEmployment().equals(EmploymentType.FULL)) {
                    guide.setContract(employeeDTO.getContract());
                }
                return guide;
            case "MANAGER":
                Manager manager = Manager.builder()
                        .name(employeeDTO.getName())
                        .lastName(employeeDTO.getLastName())
                        .email(employeeDTO.getLastName())
                        .phone(employeeDTO.getPhone())
                        .salary(employeeDTO.getSalary())
                        .workAmount(employeeDTO.getWorkAmount())
                        .employment(EmploymentType.valueOf(employeeDTO.getEmployment()))
                        .bonus(employeeDTO.getBonus())
                        .build();
                if (manager.getEmployment().equals(EmploymentType.FULL)) {
                    manager.setContract(employeeDTO.getContract());
                }
                return manager;
            default:
                throw new Exception("Wrong type of employee");
        }

    }

    public abstract void calculateSalary();

    public void removeEmployee() {};
}
