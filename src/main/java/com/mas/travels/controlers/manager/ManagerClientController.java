package com.mas.travels.controlers.manager;

import com.mas.travels.models.dto.request.ClientDTO;
import com.mas.travels.models.dto.request.TravelDTO;
import com.mas.travels.models.dto.response.TravelResponseDTO;
import com.mas.travels.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Controller
@RequestMapping("manager/client")
@RequiredArgsConstructor
public class ManagerClientController {

    private final ClientService clientService;

    @PostMapping()
    public ResponseEntity<?> addNewRegisteredClient(@RequestBody ClientDTO clientDTO) {
        try {
            return new ResponseEntity<>(clientService.addNewClient(clientDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllRegisteredClients() throws EntityNotFoundException {
        try {
            return new ResponseEntity<>(clientService.getAllRegisteredClients(), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{clientId}")
    public ResponseEntity<?> deleteRegisteredClient(@PathVariable Long clientId) throws EntityNotFoundException {
        try {
            clientService.deleteClient(clientId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/assignTrip/{clientId}/{travelId}")
    public ResponseEntity<?> assignTravel(@PathVariable Long clientId, @PathVariable Long travelId) throws EntityNotFoundException {
        try {
            clientService.assignTravel(clientId, travelId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/travels/{clientId}")
    public ResponseEntity<?> getClientsTravels(@PathVariable Long clientId) {
        try {
            Set<TravelResponseDTO> travels =  clientService.getClientsTravels(clientId);
            return new ResponseEntity<>(travels, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

}
