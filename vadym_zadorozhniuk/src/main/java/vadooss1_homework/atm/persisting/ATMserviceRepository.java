package vadooss1_homework.atm.persisting;


public interface ATMserviceRepository {

String checkCard(long cardId, String cardType);
boolean checkPin(int pin, long cardId);
String transferMoney(int fromAccountId, int toAccountId, double sum, int serviceId);
String getCash(int atmId, int fromAccountId, int sum, int serviceId);
double getBalanceOnScreen(int fromAccountId, int serviceId);
String getBalanceInSMS(int fromAccountId, int serviceId);
String getBalancePrint(int fromAccountId, int serviceId);
String returnCard(long cardId);

}
