package com.mas.travels.models.travel;

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
@DiscriminatorValue("domesticTravel")
public class DomesticTravel extends Travel {
    private String city;
}
