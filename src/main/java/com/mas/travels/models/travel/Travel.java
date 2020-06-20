package com.mas.travels.models.travel;

import com.mas.travels.models.client.RegisteredClient;
import com.mas.travels.models.common.BaseEntity;
import com.mas.travels.models.common.Theme;
import com.mas.travels.models.dto.request.TravelDTO;
import com.mas.travels.models.employee.Guide;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "travel_type",
        discriminatorType = DiscriminatorType.STRING)
public class Travel extends BaseEntity {
    private Integer price;
    @ManyToMany(mappedBy = "travels")
    private Set<RegisteredClient> clients;
    @Enumerated(STRING)
    private Theme theme;
    private Integer rate;
    @Embedded
    private InformationCard informationCard;
    @ManyToMany(mappedBy = "travels")
    private Set<Guide> guides;

    public static Travel createTravel(TravelDTO travelDTO) throws Exception {
        if (travelDTO.getType().equals("Abroad")) {
            return AbroadTravel.builder()
                    .conveyance(travelDTO.getConveyance())
                    .country(travelDTO.getCountry())
                    .price(travelDTO.getPrice())
                    .rate(travelDTO.getRate())
                    .informationCard(InformationCard.createInformationCard(travelDTO.getInformationCard()))
                    .theme(Theme.valueOf(travelDTO.getTheme()))
                    .build();
        } else if (travelDTO.getType().equals("Domestic")) {
            return DomesticTravel.builder()
                    .city(travelDTO.getCity())
                    .price(travelDTO.getPrice())
                    .rate(travelDTO.getRate())
                    .informationCard(InformationCard.createInformationCard(travelDTO.getInformationCard()))
                    .theme(Theme.valueOf(travelDTO.getTheme()))
                    .build();
        } else {
            throw new Exception("Wrong type of travel");
        }
    }

    public void askForContact() {
    }

}
