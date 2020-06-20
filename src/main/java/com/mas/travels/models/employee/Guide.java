package com.mas.travels.models.employee;

import com.mas.travels.models.travel.Travel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("guide")
public class Guide extends Employee {

    @ElementCollection
    private Set<String> languages;


    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "guide_travel",
            joinColumns = { @JoinColumn(name = "guide_id") },
            inverseJoinColumns = { @JoinColumn(name = "travel_id") }
    )
    private Set<Travel> travels;

    @Override
    public void calculateSalary() {}
}
