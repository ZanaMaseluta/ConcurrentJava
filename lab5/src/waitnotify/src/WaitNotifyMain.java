package waitnotify.src;

public class WaitNotifyMain {

    public static void main(String[] args) {
        MyThread b = new MyThread();
        new Thread(b).start();

        synchronized (b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Total is: " + b.total);
        }
    }
}
