package multipleProducersMultipleConsumers;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author cristian.chilipirea
 *
 */
public class Buffer {
	BlockingQueue<Integer> buff = new ArrayBlockingQueue<Integer>(5);

	void put(int value) {
		Integer val = new Integer(value);
		try {
			buff.put(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	int get() {

		int value = -1;
		try {
			value = buff.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return value;
	}
}
