package com.mas.travels.controlers.manager;

import com.mas.travels.models.dto.request.TravelDTO;
import com.mas.travels.services.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


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
}
