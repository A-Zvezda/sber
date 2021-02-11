package org.sber.utils;

import org.sber.entity.MyConsumer;

import java.time.Duration;
import java.time.Instant;


public class MyConsumerThread extends Thread{

    MyConsumer myConsumer;

    public MyConsumerThread(MyConsumer deferredExecutor) {
        this.myConsumer = deferredExecutor;
    }

    @Override
    public void run() {
        try {
           while (!Thread.interrupted()) {
               Instant start = Instant.now();
               myConsumer.getConsumer().accept(myConsumer.getDelay());
               Thread.sleep(myConsumer.getDelay() * 1000);
               Instant end = Instant.now();
               System.out.println(Duration.between(start, end));
           }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

    }
}
