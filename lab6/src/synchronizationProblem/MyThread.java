package synchronizationProblem;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cristian.chilipirea
 * 
 */
public class MyThread implements Runnable {
	int id;
	static AtomicInteger value = new AtomicInteger();
	//static int value;
	MyThread(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		if (id == 0) {
			for (int i = 0; i < Main.N; i++) {
				value.addAndGet(3);
				//value = result.get();
			}
		} else {
			for (int i = 0; i < Main.N; i++){
				value.addAndGet(3);
				//value=result.get();
			}



		}
	}
}
