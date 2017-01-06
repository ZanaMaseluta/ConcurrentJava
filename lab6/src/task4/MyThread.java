package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Created by andra on 11.11.2016.
 */
public class MyThread implements Runnable {

    int id;
    String filename;
    Semaphore sem;
    ArrayList<Integer> list;
    CyclicBarrier cb;

    MyThread(int id, String filename, Semaphore sem, ArrayList<Integer> list, CyclicBarrier cb){
        this.id = id;
        this.filename = filename;
        this.sem = sem;
        this.list = list;
        this.cb = cb;
    }

    synchronized void putToList(int value){
        list.add(value);
    }

    @Override
    public void run() {

        File file = new File(filename);

        try {

            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                int i = sc.nextInt();
                //System.out.println(i);
                putToList(i);
            }
            sc.close();
            sem.release();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
