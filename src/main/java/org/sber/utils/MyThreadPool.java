package org.sber.utils;

import org.sber.entity.MyConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    private ArrayList<MyConsumer> myConsumerList;

    public List<MyConsumer> getMyConsumerList() {
        return myConsumerList;
    }

    public void setMyConsumerList(ArrayList<MyConsumer> myConsumerList) {
        this.myConsumerList = myConsumerList;
    }

    public MyThreadPool(ArrayList<MyConsumer> myConsumerList) {
        this.myConsumerList = myConsumerList;
    }

    public void startMyThreadPool() {

        ExecutorService executor = Executors.newFixedThreadPool(5);

            for (MyConsumer o:myConsumerList) {
                Runnable worker = new MyConsumerThread(o);
                executor.execute(worker);
            }
        executor.shutdown();
        while (!executor.isTerminated()) {
            try {
                executor.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished all threads");
    }
}
