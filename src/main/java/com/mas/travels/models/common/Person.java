package com.mas.travels.models.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import javax.persistence.MappedSuperclass;


@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public abstract class Person extends BaseEntity {
    private String name;
    private String lastName;
    @NotNull
    private String email;
    private String phone;
}
