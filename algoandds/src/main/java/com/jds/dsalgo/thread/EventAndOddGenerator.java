package com.jds.dsalgo.thread;

public class EventAndOddGenerator {

	public static void main(String[] args) {
		String object1 = "Ashjks";
		new OddThread(object1).start();
		new EventThread(object1).start();
	}

}

class EventThread extends Thread {
	Object object;
	int even = 2;

	public EventThread(Object object2) {
		this.object = object2;
	}

	@Override
	public void run() {
		synchronized (object) {
			while (true) {
				if (even % 2 == 0) {
					System.out.print(even + ",");
					even = even + 2;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					object.notify();
				}
				try {
					object.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class OddThread extends Thread {
	Object object;
	int odd = 1;

	OddThread(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		synchronized (object) {
			while (true) {
				if (odd % 2 != 0) {
					System.out.print(odd + ",");
					odd = odd + 2;
					object.notify();
				}
				try {
					object.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}
}