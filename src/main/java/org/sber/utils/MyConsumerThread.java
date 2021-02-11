package org.sber.utils;

import org.sber.entity.MyConsumer;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.function.Consumer;


public class MyConsumerThread extends Thread{

    MyConsumer myConsumer;

    public MyConsumerThread(MyConsumer myConsumer) {
        this.myConsumer = myConsumer;
    }

    @Override
    public void run() {
        int i = 0;
        try {
           while (!Thread.interrupted()) {
               Instant start = Instant.now();
               Thread.sleep(myConsumer.getDelay());
               Instant end = Instant.now();
               System.out.print(Thread.currentThread().getName() + "  Time: " + Duration.between(start, end) + " Delay : ");
               myConsumer.getConsumer().accept(myConsumer.getDelay());
               if (i == myConsumer.getReplyQuantity()) {
                   Thread.currentThread().interrupt();
               }
               i++;
           }

        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

    }
}
