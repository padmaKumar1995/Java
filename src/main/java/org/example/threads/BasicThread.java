package org.example.threads;

public class BasicThread extends Thread {
    public void run() {
        System.out.println("thread 1 started");
        System.out.println("thread 1 finished");
    }
}
