package org.example.threads;

public class ThreadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("thread runnable start");
        System.out.println("thread runnable finished");
    }
}
