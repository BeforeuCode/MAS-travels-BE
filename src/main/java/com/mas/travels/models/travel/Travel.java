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
    private String title;
    private Integer price;
    @ManyToMany(mappedBy = "travels", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<RegisteredClient> clients;
    @Enumerated(STRING)
    private Theme theme;
    private Integer rate;
    @Embedded
    private InformationCard informationCard;
    @ManyToMany(mappedBy = "travels", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Guide> guides;

    public static Travel createTravel(TravelDTO travelDTO) throws Exception {
        if (travelDTO.getType().equals("ABROAD")) {
            return AbroadTravel.builder()
                    .title(travelDTO.getTitle())
                    .conveyance(travelDTO.getConveyance())
                    .country(travelDTO.getCountry())
                    .price(travelDTO.getPrice())
                    .rate(travelDTO.getRate())
                    .informationCard(InformationCard.createInformationCard(travelDTO.getInformationCard()))
                    .theme(Theme.valueOf(travelDTO.getTheme()))
                    .build();
        } else if (travelDTO.getType().equals("DOMESTIC")) {
            return DomesticTravel.builder()
                    .title(travelDTO.getTitle())
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

    @PreRemove
    private void removeClientsFromTravels(){
        for(RegisteredClient c : clients ) {
            c.getTravels().remove(this);
        }
    }

}
