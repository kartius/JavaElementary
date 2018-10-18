package vadooss1_homework.atm.persisting;

import vadooss1_homework.atm.model.ATM;
import vadooss1_homework.atm.model.Account;
import vadooss1_homework.atm.model.Card;

public interface ATMserviceRepository {

boolean checkCard(Card card);
boolean checkPin(int pin, Card card);
void transferMoney(Account ac1, Account ac2, double sum);
void getCash(ATM atm, Account ac, int sum);
double getBalanceOnScreen(Account ac);
double getBalanceInSMS(Account ac);
double getBalancePrint(Account ac);


}
