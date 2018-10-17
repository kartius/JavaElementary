package ua.od.hillel.lesson_29_locks.account;

public class Operations {


    static void transfer(Account a1, Account a2, int amount) throws Exception {

        try {
            if (a1.getLock().tryLock()) {
                try {
                    if (a2.getLock().tryLock()) {
                        if (a1.getBalance() < amount) {
                            throw new Exception("operation unsupported");
                        }

                        a1.withdraw(amount);
                        a2.deposit(amount);
                    } else {
                        a2.incFailedCounter();
                        System.out.println("failed lock");
                    }
                } finally {
                    a2.getLock().unlock();
                }

            } else {
                a1.incFailedCounter();
                System.out.println("failed lock");
            }


        } finally {
            a1.getLock().unlock();
        }


//        synchronized (a1) {
//            sleep(500);
//
//            synchronized (a2) {
//                if (a1.getBalance() < amount) {
//                    throw new Exception("operation unsupported");
//                }
//
//                a1.withdraw(amount);
//                a2.deposit(amount);
//
//            }
//        }

    }


    public static void main(String[] args) throws Exception {


        Account a = new Account(2000);
        Account b = new Account(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    transfer(a, b, 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

        transfer(b, a, 200);

    }
}
