package org.sber;

import org.sber.entity.MyConsumer;
import org.sber.interfaces.DeferredExecutor;
import org.sber.utils.MyThreadPool;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        ArrayList<MyConsumer> myConsumerList = new ArrayList<MyConsumer>();
        long leftLimit = 1L;
        long rightLimit = 40L;
        for (int i = 0; i < 20; i++)
        {
            myConsumerList.add( new MyConsumer(leftLimit + (long) (Math.random() * (rightLimit - leftLimit)), (Consumer<Long>) s -> System.out.println(s)));
        }

        Runnable task = () -> {
            int counter = 0;
            new MyThreadPool(myConsumerList).startMyThreadPool();
            while (!Thread.interrupted()){
                if (counter == 30) {
                    Thread.currentThread().interrupt();
                }

                for (int i = 0; myConsumerList.size() > i; i++) {
                    myConsumerList.get(i).setDelay(leftLimit + (long) (Math.random() * (rightLimit - leftLimit)));
                }
                counter++;
            }
        };
        task.run();
    }
}
