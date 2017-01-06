package cyclicbarrier.src;

import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {

    private int duration;
    private CyclicBarrier barrier;

    public MyThread(int duration, CyclicBarrier barrier) {
        this.duration = duration;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println("Thread " + Thread.currentThread().getId() + " is calling await()");
            barrier.await();
            System.out.println("Thread " + Thread.currentThread().getId() + " has started running again");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
