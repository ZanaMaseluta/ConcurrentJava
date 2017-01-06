package semaphore.src;

import java.util.ArrayList;

public class SemaphoreMain {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        int maxThreads = 4;
        
        ConnectionLimiter limiter = new ConnectionLimiter(maxThreads);
        
        for (int i = 0; i < maxThreads + 1; i++) {
            Thread t = new Thread(new MyThread("http://www.site" + i + ".ro", limiter));
            threads.add(t);
            t.start();
        }
        
        for (Thread t : threads) {
            t.join();
        }
    }
}
