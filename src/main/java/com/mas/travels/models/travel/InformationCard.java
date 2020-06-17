package com.mas.travels.models.travel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class InformationCard {
    private String information;
    private String comments;
    private String restrictions;
}
