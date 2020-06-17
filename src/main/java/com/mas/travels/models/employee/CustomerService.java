package com.mas.travels.models.employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("customerService")
public class CustomerService extends Employee {
    private Integer employeeRanking;

    @Override
    public void calculateSalary() {

    }
}
