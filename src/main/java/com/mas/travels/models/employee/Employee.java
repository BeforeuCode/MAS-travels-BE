package com.mas.travels.models.employee;

import com.mas.travels.models.common.Person;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="employee_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Employee extends Person {
    private Integer salary;
    private static Integer minimalSalary;
    private Integer workAmount;
    @Enumerated(STRING)
    private EmploymentType employment;
    private String contract;

    public abstract void calculateSalary();
    public void addEmployee() {};
    public void removeEmployee() {};
}
