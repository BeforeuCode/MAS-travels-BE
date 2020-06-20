package com.mas.travels.models.client;

import com.mas.travels.models.travel.Travel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("registered")
public class RegisteredClient extends Client {

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "registered_client_travel",
            joinColumns = { @JoinColumn(name = "client_id") },
            inverseJoinColumns = { @JoinColumn(name = "travel_id") }
    )
    private Set<Travel> travels;

    public void assignTravel(Travel travel) {
        travels.add(travel);
    }

}
