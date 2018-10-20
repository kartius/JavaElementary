package vadooss1_homework.atm.service;

import vadooss1_homework.atm.controller.DTO;
import vadooss1_homework.atm.persisting.ATMserviceRepository;

public class ServiceATM {
    ATMserviceRepository serviceRepository;

    public ServiceATM(ATMserviceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
    public DTO execute(DTO dto){
        String message;
        boolean result;
        double sum;
        if(dto.serviceKindId==1)
        {message = serviceRepository.checkCard(dto.cardId, dto.cardType);
        dto.message = message;
        dto.OperationSuccess = Boolean.valueOf(message.substring(message.indexOf(":")+1));
        return dto;
        }
        if(dto.serviceKindId==2)
        {result = serviceRepository.checkPin(dto.pinUserEnter, dto.cardId);
            dto.message = "Pin is checked";
            dto.OperationSuccess = result;
            return dto;
        }
        if(dto.serviceKindId==3){
            message = serviceRepository.getCash(dto.atmId,dto.accountFromId,((int)dto.sumEnter),dto.serviceKindId);
            dto.message = message;
            dto.OperationSuccess = Boolean.valueOf(message.substring(message.indexOf(":")+1));
            return dto;
        }
        if(dto.serviceKindId==4){
            message = serviceRepository.transferMoney(dto.accountFromId,dto.accountOnId,dto.sumEnter,dto.serviceKindId);
            dto.message = message;
            dto.OperationSuccess = Boolean.valueOf(message.substring(message.indexOf(":")+1));
            return dto;
        }
        if(dto.serviceKindId==5){
            sum = serviceRepository.getBalanceOnScreen(dto.accountFromId,dto.serviceKindId);
            dto.message = "Screen shows balance "+sum+" money";
            dto.OperationSuccess = true;
            return dto;
        }
        if(dto.serviceKindId==6){
            message = serviceRepository.getBalanceInSMS(dto.accountFromId,dto.serviceKindId);
            dto.message = message;
            dto.OperationSuccess = Boolean.valueOf(message.substring(message.indexOf(":")+1));
            return dto;
        }
        if(dto.serviceKindId==7){
            message = serviceRepository.getBalancePrint(dto.accountFromId,dto.serviceKindId);
            dto.message = message;
            dto.OperationSuccess = Boolean.valueOf(message.substring(message.indexOf(":")+1));
            return dto;
        }
        if(dto.serviceKindId==8){
            message = serviceRepository.returnCard(dto.cardId);
            dto = new DTO();
            dto.message = message;
            dto.returnCard = true;
            return dto;
        }

        return new DTO();
    }

}
