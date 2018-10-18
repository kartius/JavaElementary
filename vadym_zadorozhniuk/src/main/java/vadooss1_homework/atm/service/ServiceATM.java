package vadooss1_homework.atm.service;

import vadooss1_homework.atm.controller.DTO;
import vadooss1_homework.atm.persisting.ATMserviceRepository;

public class ServiceATM {
    ATMserviceRepository serviceRepository;

    public ServiceATM(ATMserviceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

}
