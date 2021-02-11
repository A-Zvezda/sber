package org.sber;

import org.sber.entity.MyConsumer;
import org.sber.utils.MyConsumerThread;
import org.sber.utils.MyThreadPool;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Main {
    private static Object Consumer;

    public static void main(String[] args) {

        ArrayList<MyConsumer> myConsumerList = new ArrayList<MyConsumer>();

        MyConsumer myConsumer = new MyConsumer(12L,new Consumer<Long>() {
            @Override
            public void accept(Long s) {
                System.out.println(s);
            }
        });
        myConsumerList.add(myConsumer);
        new MyThreadPool(myConsumerList).startMyThreadPool();

    }
}
