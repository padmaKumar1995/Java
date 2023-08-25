package org.example.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class OddAndEven {

    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(1);

        Thread a1 = new Thread(() -> {
            while (a.get() < 10) {
                if(a.get() % 2 != 0) {
                    System.out.println(a.get());
                    a.getAndIncrement();
                }
            }
        });

        Thread a2 = new Thread(() -> {
            while (a.get() < 10) {
                if(a.get() % 2 == 0) {
                    System.out.println(a.get());
                    a.getAndIncrement();
                }
            }
        });

        a1.start();
        a2.start();
    }
}
