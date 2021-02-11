package org.sber.entity;

import org.sber.interfaces.DeferredExecutor;

import java.util.function.Consumer;

public class MyConsumer  implements DeferredExecutor{
    long delay;
    Consumer consumer;

    public MyConsumer(long delay, Consumer consumer) {
        this.delay = delay;
        this.consumer = consumer;
    }

    @Override
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void setDelay(long delay) {
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
