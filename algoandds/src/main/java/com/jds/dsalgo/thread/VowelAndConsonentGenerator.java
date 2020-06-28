package com.jds.dsalgo.thread;

public class VowelAndConsonentGenerator {

	public static void main(String[] args) {
		Object obj = new Object();
		new Thread(new VowelGenerator(obj)).start();
		new Thread(new ConsonentGenerator(obj)).start();
	}

}

class VowelGenerator implements Runnable {

	private Object obj;

	VowelGenerator(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		int i = 'a';
		while (i <= 'u') {
			synchronized (obj) {
				if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
					System.out.print("<" + (char) i + ">");

					obj.notify();
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				i++;
			}
		}
	}
}

class ConsonentGenerator implements Runnable {

	private Object obj;

	ConsonentGenerator(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		int i = 'b';
		while (i <= 'z') {
			synchronized (obj) {
				if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {

					obj.notify();
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.print((char) i);
				}
				if (i == 'z') {
					// after printing u, vowel went to wait state
					obj.notify();
				}

				i++;
			}
		}
	}
}