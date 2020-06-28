package com.jds.dsalgo.algoandds.synchttps;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQuueTester {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new SynchronousQueue<Integer>();
		Consumers consumers=new Consumers(blockingQueue);
		Producer producer=new Producer(blockingQueue);
		consumers.start();
		producer.start();

	}

}

class Consumers extends Thread {
	BlockingQueue<Integer> blockingQueue = null;

	public Consumers(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumer:Fetching");
				int value = blockingQueue.take();
				System.out.println("Consumer:Fetched-" + value);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Producer extends Thread {
	BlockingQueue<Integer> blockingQueue = null;

	public Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {

			System.out.println("Producer:Insering");
			int value = new Random().nextInt(100);
			blockingQueue.offer(value);
			System.out.println("Producer:Inserted" + value);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}