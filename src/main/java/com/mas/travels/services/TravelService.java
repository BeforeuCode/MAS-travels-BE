package com.mas.travels.services;

import com.mas.travels.models.dto.request.TravelDTO;
import com.mas.travels.models.travel.Travel;
import com.mas.travels.repositories.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
