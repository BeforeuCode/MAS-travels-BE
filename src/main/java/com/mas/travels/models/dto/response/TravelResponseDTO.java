package com.mas.travels.models.dto.response;

import com.mas.travels.models.travel.AbroadTravel;
import com.mas.travels.models.travel.DomesticTravel;
import com.mas.travels.models.travel.InformationCard;
import com.mas.travels.models.travel.Travel;
import lombok.Data;

@Data
public class TravelResponseDTO {
    private String title;
    private Long id;
    private Integer price;
    private String theme;
    private Integer rate;
    private String type;
    private String country;
    private String conveyance;
    private String city;
    private InformationCard informationCard;

    public TravelResponseDTO(Travel travel){
        title = travel.getTitle();
        id = travel.getId();
        price = travel.getPrice();
        theme = travel.getTheme().name();
        rate = travel.getRate();
        informationCard = travel.getInformationCard();
        if(travel instanceof AbroadTravel) {
            type = "Abroad travel";
            country = ((AbroadTravel) travel).getCountry();
            conveyance = ((AbroadTravel) travel).getConveyance();
        } else if( travel instanceof DomesticTravel) {
            type = "Domestic travel";
            city = ((DomesticTravel) travel).getCity();
        }

    }
}
