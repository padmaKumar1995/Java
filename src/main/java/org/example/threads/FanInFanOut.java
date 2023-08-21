package org.example.threads;

import java.util.ArrayList;

/*
Example for synchronization
 */
public class FanInFanOut {
    /*
    We have an array of 50 objects
    Print 1-10 from sequentially 1 thread
    then print 11-40 using n parallel threads
    the print 41-50 sequentially in 1 thread

    do this without using thread only (no executor, no forkjoinpool)
     */

    public static void main(String[] args) throws InterruptedException {
        new FanOutFanIn(4).run();
    }

    static class FanOutFanIn {
        int i;
        int threadCount;
        ArrayList<Thread> threads = new ArrayList<>();

        public FanOutFanIn(int threadCount) {
            this.threadCount = threadCount;
        }

        void run() throws InterruptedException {
            i = 0;
            //1-10 sequentially
            while (i <= 10) {
                printNext();
            }

            for(int j = 0; j < threadCount; j++) {
                threads.add(new Thread(() -> {
                    while (i <= 40) {
                        synchronized (this) {
                            //double check locking
                            if(i <= 40) {
                                printNext();
                            }
                        }
                    }
                }));
            }
            threads.forEach(Thread::start);
            for (Thread thread: threads) {
                thread.join();
            }

            //41-50 sequentially
            while (i <= 50) {
                printNext();
            }
        }

        private synchronized void printNext() {
            print(i);
            i++;
            notify();
        }

        void print(int i) {
            System.out.println("Thread " + Thread.currentThread().getName() + " " + i);
        }
    }
}
