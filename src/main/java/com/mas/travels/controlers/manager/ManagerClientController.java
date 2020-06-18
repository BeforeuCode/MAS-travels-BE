package com.mas.travels.controlers.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manager/client")
public class ManagerClientController {

    public void getAllRegisteredClients(){};
    public void addNewRegisteredClient(){};
    public void removeRegisteredClient(){};
    public void assignTravel(){};
    public void getClientTravels(){};

}
