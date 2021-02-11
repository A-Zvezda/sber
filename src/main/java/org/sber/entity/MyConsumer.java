package org.sber.entity;

import org.sber.interfaces.DeferredExecutor;

import java.util.function.Consumer;

public class MyConsumer<T> implements DeferredExecutor<T>{
    long delay;
    Consumer consumer;
    int replyQuantity = 10;

    public MyConsumer(long delay, Consumer consumer) {
        this.setDelay(delay);
        this.consumer = consumer;
    }

    public int getReplyQuantity() {
        return replyQuantity;
    }

    @Override
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public synchronized void setDelay(long delay) {
        if (delay < 0.9) {
            throw new IllegalArgumentException("The argument must be greater or equal to 1 ");
        }
        this.delay = delay;
    }

    public long getDelay() {
        return delay;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    @Override
    public void accept(Object t) {

    }
}
