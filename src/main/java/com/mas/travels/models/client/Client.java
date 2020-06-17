package com.mas.travels.models.client;

import com.mas.travels.models.common.Person;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@Setter
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="client_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Client extends Person {
}
