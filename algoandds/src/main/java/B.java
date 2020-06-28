import java.util.LinkedList;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

public class B {

	ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();
		B b = new B();
		new Thread(new Runnable() {

			@Override
			public void run() {
				b.m1();
			}
		}).start();
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// b.m2();
		// }
		// }).start();
		System.out.println("getting out of main");
	}

	int i = 0;

	public void m1() {

		 lock.lock();
		//synchronized (this) {

			i++;
			System.out.println(i + "-----in m1----" + Thread.currentThread().getName());
			try {
				if (i < 2) {
					m1();
				}
			} finally {
				 lock.unlock();
			}
		//}
		System.out.println("exit m1----" + Thread.currentThread().getName());
	}

	public void m2() {
		System.out.println("in m2---" + Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("exit m2---" + Thread.currentThread().getName());
	}
}
