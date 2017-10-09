package com.test.producer.consumer.semaphore;

import java.util.ArrayList;
import java.util.List;

import com.test.custom.semaphore.CustomSemaphore;

public class Resource {
	private static final List<Integer> BUFFER = new ArrayList<>();
	private static final int MAX_BUFFER_SIZE = 20;
	private static final int MIN_BUFFER_SIZE = 0;
	private volatile static Resource res = null;
	private final CustomSemaphore resourceManager = new CustomSemaphore(MAX_BUFFER_SIZE);

	private Resource() {
	}

	public static Resource getInstance() {
		if (res == null) {
			synchronized (Resource.class) {
				if (res == null) {
					res = new Resource();
				}
			}
		}
		return res;
	}

	public void produce(int val) {
		resourceManager.acquire();
		synchronized (BUFFER) {
			boolean isAdded = BUFFER.add(val);
			if (isAdded)
				System.out.println(Thread.currentThread().getName()
						+ " produces " + val);
			
		}
	}

	public void consume(Integer val) {

		synchronized (BUFFER) {
			if (BUFFER.size() == MIN_BUFFER_SIZE) {
				try {
					BUFFER.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			boolean isRemoved = BUFFER.remove(val);
			if (isRemoved)
				System.out.println(Thread.currentThread().getName()
						+ " consumes " + val);
			BUFFER.notify();
		}
	}

}
