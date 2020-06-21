package com.mas.travels.controlers.manager;

import com.mas.travels.models.dto.request.InformationCardDTO;
import com.mas.travels.models.dto.request.TravelDTO;
import com.mas.travels.services.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;


@Controller
@RequestMapping("manager/travel")
@RequiredArgsConstructor
public class ManagerTravelController {

    private final TravelService travelService;

    public void getAllTravels() {
    }

    @PostMapping()
    public ResponseEntity<?> addNewTravel(@RequestBody TravelDTO travelDTO) {
        try {
            return new ResponseEntity<>(travelService.addNewTravel(travelDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{travelId}")
    public ResponseEntity<?> deleteTravel(@PathVariable Long travelId) throws EntityNotFoundException {
        try {
            travelService.deleteTravel(travelId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/informationCard/{travelId}")
    public ResponseEntity<?> updateInformationCard(@RequestBody InformationCardDTO informationCardDTO,
                                                   @PathVariable Long travelId) throws EntityNotFoundException {

        try {
            travelService.updateInformationCard(informationCardDTO, travelId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/informationCard/{travelId}")
    public ResponseEntity<?> updateInformationCard(@PathVariable Long travelId) throws EntityNotFoundException {
        try {

            return new ResponseEntity<>(travelService.getInformationCard(travelId), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }
}
