package com.mas.travels.models.employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("manager")
public class Manager extends Employee {
    private Integer bonus;

    @Override
    public void calculateSalary() {

    }
}
