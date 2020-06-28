package com.jds.dsalgo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaitAndNotify {

	public static void main(String[] args) {
		Object object = new Object();
		List<Integer> list = new ArrayList<Integer>();
		new Producer(object, list).start();
		new Consumer(object, list).start();
	}

}

class Producer extends Thread {
	private Object object;
	private List<Integer> list;

	public Producer(Object object, List<Integer> list) {
		this.object = object;
		this.list = list;
	}

	public void run() {
		while (true) {
			synchronized (object) {
				if (list.size() == 1) {
					try {
						System.out.println("waiting in producer");
						object.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random random = new Random();
				list.add(random.nextInt());
				System.out.println("Produced:" + list.get(0));
				object.notify();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

class Consumer extends Thread {
	private Object object;
	private List<Integer> list;

	public Consumer(Object object, List<Integer> list) {
		this.object = object;
		this.list = list;

	}

	public void run() {
		while (true) {
			synchronized (object) {
				if (list.isEmpty()) {
					System.out.println("wating in consumer");
					try {
						object.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Consumed:" + list.remove(0));
				object.notify();
			}
		}
	}
}
