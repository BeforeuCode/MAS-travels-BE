package com.mas.travels.services;

import com.mas.travels.models.client.Client;
import com.mas.travels.models.client.RegisteredClient;
import com.mas.travels.models.dto.request.ClientDTO;
import com.mas.travels.models.dto.response.TravelResponseDTO;
import com.mas.travels.models.travel.Travel;
import com.mas.travels.repositories.ClientRepository;
import com.mas.travels.repositories.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final TravelRepository travelRepository;

    public Client addNewClient(ClientDTO clientDTO) throws Exception {
        Client client = Client.createClient(clientDTO);
        clientRepository.save((RegisteredClient) client);
        return client;
    }
    public Set<RegisteredClient> getAllRegisteredClients() throws EntityNotFoundException {
        return clientRepository.findAll();
    }

    public void deleteClient(Long id) {
        Optional<RegisteredClient> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()){
            clientRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException();
        }
    }

    public void assignTravel(Long clientId, Long travelId) throws EntityNotFoundException {
        Optional<RegisteredClient> clientOptional = clientRepository.findById(clientId);
        Optional<Travel> travelOptional = travelRepository.findById(travelId);

        if(clientOptional.isPresent() && travelOptional.isPresent()) {
            RegisteredClient client = clientOptional.get();
            Travel travel = travelOptional.get();
            client.assignTravel(travel);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Set<TravelResponseDTO> getClientsTravels(Long clientId) {
        Optional<RegisteredClient> clientOptional = clientRepository.findById(clientId);
        if(clientOptional.isPresent()){
            return travelRepository.findAllTravelsByClientId(clientOptional.get().getId()).stream().map(TravelResponseDTO::new).collect(Collectors.toSet());
        }else {
            throw new EntityNotFoundException();
        }
    }
}
