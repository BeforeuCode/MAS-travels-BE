package com.mas.travels.models.travel;

import com.mas.travels.models.dto.request.InformationCardDTO;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Embeddable
public class InformationCard {
    private String information;
    private String comments;
    private String restrictions;

    public static InformationCard createInformationCard(InformationCardDTO informationCardDTO){
        if(informationCardDTO != null) {
            return  InformationCard.builder()
                    .information(informationCardDTO.getInformation())
                    .restrictions(informationCardDTO.getRestrictions())
                    .comments(informationCardDTO.getComments())
                    .build();
        } else {
            return null;
        }
    }
}
