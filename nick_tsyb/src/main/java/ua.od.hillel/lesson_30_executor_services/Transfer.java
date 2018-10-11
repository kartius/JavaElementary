package ua.od.hillel.lesson_30_executor_services;

import ua.od.hillel.lesson_29_locks.account.Account;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class Transfer implements Callable<Boolean> {


    private Account account1;
    private Account account2;
    private int amount;

    public Transfer(Account account1, Account account2, int amount) {
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        try {
            if (account1.getLock().tryLock()) {
                System.out.println("lock ac1");
                try {
                    if (account2.getLock().tryLock()) {
                        System.out.println("lock ac2");
                        if (account1.getBalance() < amount) {
                            throw new Exception("operation unsupported");
                        }

                        account1.withdraw(amount);
                        account2.deposit(amount);
                        System.out.println("success transfer!");
                        sleep(1000);
                        return true;

                    } else {
                        account2.incFailedCounter();
                        System.out.println("failed lock");
                        return false;
                    }

                } finally {
                    System.out.println("unlock a2");
                    account2.getLock().unlock();
                }
            } else {
                account1.incFailedCounter();
                System.out.println("failed lock");
                return false;
            }
        } finally {
            System.out.println("unlock a1");
            account1.getLock().unlock();
        }
    }
}



