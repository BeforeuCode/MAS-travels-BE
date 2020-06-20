package com.mas.travels.models.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class AddEmployeeDTO {
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
    private Set<String> languages;
    private Integer bonus;
}
