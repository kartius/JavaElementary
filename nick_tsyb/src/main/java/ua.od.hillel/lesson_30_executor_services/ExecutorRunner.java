package ua.od.hillel.lesson_30_executor_services;

import ua.od.hillel.lesson_29_locks.account.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorRunner {


    public static void main(String[] args) throws ExecutionException, InterruptedException {




        Random rundom = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Boolean> list = new ArrayList<>();


        Account a1 = new Account(1000);
        Account a2 = new Account(2000);


        for (int i = 0; i < 10; i++) {


            Future<Boolean> submit = executorService.submit(new Transfer(a1, a2, rundom.nextInt(200)));
            list.add(submit.get());

        }

        executorService.shutdown();


        for (Boolean aBoolean : list) {
            System.out.println(aBoolean);
        }



    }


}
