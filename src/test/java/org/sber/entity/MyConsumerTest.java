package org.sber.entity;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class MyConsumerTest {

    @Test
    void setDelay() {
        MyConsumer myConsumer1 = new MyConsumer(5L,new Consumer<Long>() {
            @Override
            public void accept(Long s) {
                System.out.println(s);
            }
        });
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()->{myConsumer1.setDelay(-10);} );
    }
    @Test
    void myConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new MyConsumer(-5L,new Consumer<Long>() {
            @Override
            public void accept(Long s) {
                System.out.println(s);
            }
        }));
    }

}