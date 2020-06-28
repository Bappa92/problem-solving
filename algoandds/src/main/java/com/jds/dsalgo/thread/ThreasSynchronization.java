package com.jds.dsalgo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreasSynchronization {
	Lock locker;
	public ThreasSynchronization(Lock locker) {
		this.locker=locker;
	}

	public static void main(String[] args) {
		 Lock locker=new ReentrantLock();

		ThreasSynchronization ts = new ThreasSynchronization(locker);
		ThreasSynchronization ts1 = new ThreasSynchronization(locker);
		new A(ts).start();
		new A(ts1).start();
	}

	public void hello() {
		locker.lock();
		System.out.println("entering hello" + Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("exting" + Thread.currentThread().getName());
		locker.unlock();
	}
}

class A extends Thread {
	ThreasSynchronization ts;

	public A(ThreasSynchronization ts) {
		super();
		this.ts = ts;
	}

	@Override
	public void run() {
		ts.hello();
	}

}
