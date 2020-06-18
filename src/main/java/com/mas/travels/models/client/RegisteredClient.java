package com.mas.travels.models.client;

import com.mas.travels.models.travel.Travel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("registered")
public class RegisteredClient extends Client {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "registered_client_travel",
            joinColumns = { @JoinColumn(name = "client_id") },
            inverseJoinColumns = { @JoinColumn(name = "travel_id") }
    )
    private List<Travel> travels;

    public void addClient() {}
    public void removeClient() {}
    public void assignTravel() {}

}
