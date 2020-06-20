package com.mas.travels.models.client;

import com.mas.travels.models.common.Person;
import com.mas.travels.models.dto.request.ClientDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "client_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Client extends Person {

    public static Client createClient(ClientDTO clientDTO) throws Exception {
        return RegisteredClient.builder()
                .name(clientDTO.getName())
                .lastName(clientDTO.getLastName())
                .email(clientDTO.getEmail())
                .phone(clientDTO.getPhone())
                .build();
    }
}
