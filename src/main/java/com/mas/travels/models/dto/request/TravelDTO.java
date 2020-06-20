package com.mas.travels.models.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class TravelDTO {
    private Integer price;
    private String theme;
    private Integer rate;
    private String type;
    private String country;
    private String conveyance;
    private String city;
    private InformationCardDTO informationCard;
    private List<Long> guidesIds;
}
