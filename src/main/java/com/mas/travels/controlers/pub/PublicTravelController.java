package com.mas.travels.controlers.pub;

import com.mas.travels.models.dto.response.TravelResponseDTO;
import com.mas.travels.services.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("public/travel")
@RequiredArgsConstructor
public class PublicTravelController {

    private final TravelService travelService;

    @GetMapping()
    public ResponseEntity<Set<TravelResponseDTO>> getAllTravels(){
        return new ResponseEntity<>(travelService.getAllTravels().stream().map(TravelResponseDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    };

    public void askForContact(){};
}
