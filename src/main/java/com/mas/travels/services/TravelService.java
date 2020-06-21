package com.mas.travels.services;

import com.mas.travels.models.dto.request.InformationCardDTO;
import com.mas.travels.models.dto.request.TravelDTO;
import com.mas.travels.models.travel.InformationCard;
import com.mas.travels.models.travel.Travel;
import com.mas.travels.repositories.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;

    public Travel addNewTravel(TravelDTO travelDTO) throws Exception {
       Travel travel = Travel.createTravel(travelDTO);
       travelRepository.save(travel);
       return travel;
    }

    public Set<Travel> getAllTravels() {
        return travelRepository.findAll();
    }

    @Transactional
    public void deleteTravel(Long travelId) {
        Optional<Travel> travelOptional = travelRepository.findById(travelId);
        if(travelOptional.isPresent()){
            Travel travel = travelOptional.get();
            travelRepository.delete(travel);
        } else {
            throw new EntityNotFoundException();
        }

    }

    public void updateInformationCard(InformationCardDTO informationCardDTO, Long travelId) {
        Optional<Travel> travelOptional = travelRepository.findById(travelId);
        if(travelOptional.isPresent()){
            Travel travel = travelOptional.get();
            InformationCard informationCard = InformationCard.builder()
                    .comments(informationCardDTO.getComments())
                    .restrictions(informationCardDTO.getRestrictions())
                    .information(informationCardDTO.getInformation())
                    .build();
            travel.setInformationCard(informationCard);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public InformationCardDTO getInformationCard(Long travelId) {
        Optional<Travel> travelOptional = travelRepository.findById(travelId);
        if(travelOptional.isPresent()){
            return new InformationCardDTO(travelOptional.get().getInformationCard());
                    } else {
            throw new EntityNotFoundException();
        }
    }
}
