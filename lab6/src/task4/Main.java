package task4;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Created by andra on 11.11.2016.
 */
public class Main {

    static ArrayList<Integer> number = new ArrayList<>();

    public static void main(String[] args) {

        Thread threads[] = new Thread[4];
        Semaphore sem = new Semaphore(3);
        CyclicBarrier cb = new CyclicBarrier(3);

        for (int i = 0; i <3; i++)
            threads[i] = new Thread(new MyThread(i, "elemente" + (i+1) + ".txt", sem, number, cb));

        threads[3] = new Thread(new SortThread(cb, number));

        for(int i=0; i<4; i++){
            threads[i].start();
        }

        for(int i=0; i<4; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i=0; i<number.size(); i++){
            System.out.print(number.get(i)+" ");
        }

    }
}
