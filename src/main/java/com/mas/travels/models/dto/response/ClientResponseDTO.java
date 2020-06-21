package com.mas.travels.models.dto.response;

import com.mas.travels.models.client.RegisteredClient;
import lombok.Data;

@Data
public class ClientResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;

    public ClientResponseDTO(RegisteredClient client){
        id = client.getId();
        name = client.getName();
        lastName = client.getLastName();
        email = client.getEmail();
        phone = client.getEmail();
    }



}
