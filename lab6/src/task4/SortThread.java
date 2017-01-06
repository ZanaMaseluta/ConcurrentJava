package task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by andra on 11.11.2016.
 */
public class SortThread implements Runnable {

    CyclicBarrier cb;
    ArrayList<Integer> list;

    SortThread(CyclicBarrier cb, ArrayList<Integer> list){
        this.cb = cb;
        this.list = list;
    }


    @Override
    public void run() {

            if(cb.getNumberWaiting() == 3) {
                Collections.sort(list);
            }
    }
}
