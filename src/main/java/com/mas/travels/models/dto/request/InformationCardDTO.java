package com.mas.travels.models.dto.request;

import com.mas.travels.models.travel.InformationCard;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InformationCardDTO {
    private String information;
    private String comments;
    private String restrictions;

    public InformationCardDTO(InformationCard informationCard){
        information = informationCard != null ? informationCard.getInformation() : null;
        comments = informationCard != null ? informationCard.getComments() : null;
        restrictions = informationCard != null  ? informationCard.getRestrictions() : null;
    }
}


