package com.mas.travels.models.employee;

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
@DiscriminatorValue("guide")
public class Guide extends Employee {

    @ElementCollection
    private List<String> languages;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "guide_travel",
            joinColumns = { @JoinColumn(name = "guide_id") },
            inverseJoinColumns = { @JoinColumn(name = "travel_id") }
    )
    private List<Travel> travels;
}
