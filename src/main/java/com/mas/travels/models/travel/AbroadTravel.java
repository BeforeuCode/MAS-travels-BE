package com.mas.travels.models.travel;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("abroadTravel")
public class AbroadTravel extends Travel {
    private String country;
    private String conveyance;
}
