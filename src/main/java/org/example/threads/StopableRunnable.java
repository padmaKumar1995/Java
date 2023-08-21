package org.example.threads;

public class StopableRunnable implements Runnable {

    private boolean stopRequested = false;

    public synchronized void requestStop() {
        stopRequested = true;
    }

    public synchronized boolean isStopRequested() {
        return this.stopRequested;
    }

    private void sleep(long milliSecs) {
        try {
            Thread.sleep(milliSecs);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Stoppable thread running");
        while (!this.stopRequested) {
            System.out.println("......");
            sleep(1000);
        }
        System.out.println("stoppable thread finished");
    }
}
