package org.example.threads;

public class ProducerConsumerExample {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer p = new ProducerConsumer();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    p.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    int ans = p.consume();
                    System.out.println(ans);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static class ProducerConsumer {
        private int data;
        private boolean hasData;

        synchronized void produce(int value) throws InterruptedException {
            while (hasData) {
                this.wait();
            }
            data = value;
            hasData = true;
            notify();
        }

        synchronized int consume() throws InterruptedException {
            while (!hasData) {
                wait();
            }
            hasData = false;
            notify();
            return data;
        }
    }
}
