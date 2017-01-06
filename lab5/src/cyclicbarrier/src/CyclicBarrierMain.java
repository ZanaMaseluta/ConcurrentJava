package cyclicbarrier.src;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {

    public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        int maxThreads = 4;
        CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("\nRelease the Kraken!!\n");
            }
        });

        for (int i = 1; i <= maxThreads; i++) {
            MyThread mt = new MyThread(1000 * i, barrier);
            Thread t = new Thread(mt);
            threads.add(t);
            t.start();
        }

        System.out.println("All threads started");

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("All threads finished");
    }

}
