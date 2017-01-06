package multipleProducersMultipleConsumers;

import java.util.concurrent.Semaphore;

/**
 * @author cristian.chilipirea
 *
 */
public class Buffer {
	int a[] = new int[10];

	static int indexEnd = 0;
    static int indexStart = 0;
	int val;
    int number;
    int currentSize = 0;

    private boolean isEmpty(){
        return (currentSize == 0);
    }

    private boolean isFull(){
        return (currentSize == 10);
    }

	synchronized void put(int value){


            while (this.isFull()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            a[(indexStart+currentSize) % 10] = value;
            currentSize++;
            notifyAll();

	}

	synchronized int get() {

        while(isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        val = a[indexStart];
        indexStart = (indexStart +1) % 10;
        currentSize--;
        notifyAll();
        return val;
	}
}
