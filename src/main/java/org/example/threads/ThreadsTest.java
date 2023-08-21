package org.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsTest {
    public void testThread() {
        //basic thread creation
        BasicThread thread1 = new BasicThread();
        thread1.start();

        //using runnable class
        Thread threadRunnable = new Thread(new ThreadRunnable());
        threadRunnable.start();

        //using runnable interface as anonymous class
        Thread runnableInterface = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable interface started");
                System.out.println("Runnable interface finished");
            }
        });
        runnableInterface.start();

        //using runnable interface with lambda expression
        Thread runnableLambda = new Thread(() -> {
            System.out.println("Runnable interface with lambda started");
            System.out.println("Runnable interface with lambda finished");
        });
        runnableLambda.start();

        //stoppable thread
        StopableRunnable stopableRunnable = new StopableRunnable();
        Thread stoppableThread = new Thread(stopableRunnable);
        stoppableThread.start();
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("requesting stop");
        stopableRunnable.requestStop();
        System.out.println("thread stopped");

        //Executor Service
        ExecutorService executorService = Executors.newCachedThreadPool();
            //Executors.newCachedThreadPool()
            //Executors.newFixedThreadPool(5) - creates pool with only 5 threads and will reuse those 5 threads for all the tasks
            //Executors.newSingleThreadExecutor() - creates only one thread, but not really useful
        for(int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println("Thread " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown(); //executors has to be shotdown, else the program will never quit waits till the executor shutsdown
    }
}

