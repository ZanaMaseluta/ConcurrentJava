package semaphore.src;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread implements Runnable {
    private String address;
    private ConnectionLimiter limiter;
    
    public MyThread(String address, ConnectionLimiter limiter) {
        this.address = address;
        this.limiter = limiter;
    }

    
    @Override
    public void run() {
        try {
            long id = Thread.currentThread().getId();
            System.out.println("Thread " + id + " waiting to connect!");
            URLConnection connection = limiter.acquire(new URL(address));
            System.out.println("Thread " + id + " connected!");
            Thread.sleep(1000);
            limiter.release(connection);
            System.out.println("Thread " + id + " disconnected!");
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
