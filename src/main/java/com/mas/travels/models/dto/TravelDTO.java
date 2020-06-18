package com.mas.travels.models.dto;

import lombok.Data;

@Data
public class TravelDTO {
    private Integer price;
    private String theme;
    private Integer rate;
    private String type;
    private String country;
    private String conveyance;
    private String city;
}
