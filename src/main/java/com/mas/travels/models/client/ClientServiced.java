package com.mas.travels.models.client;

import com.mas.travels.models.employee.CustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@IdClass(ClientServicedId.class)
public class ClientServiced {

    private Date serviceDate;

    @Id
    @ManyToOne
    @JoinColumn(name = "servicedClient_id", referencedColumnName = "id")
    private RegisteredClient servicedClient;

    @Id
    @ManyToOne
    @JoinColumn(name = "servicingEmployee_id", referencedColumnName = "id")
    private CustomerService servicingEmployee;
}
