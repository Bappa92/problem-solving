package com.jds.dsalgo.algoandds.synchttps;

import java.awt.event.MouseMotionAdapter;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskHandler implements Runnable {
	Map<Integer, Lock> locHolder = new ConcurrentHashMap<Integer, Lock>();
	BlockingQueue<Integer> blockingQueue;

	public TaskHandler() {
		blockingQueue = new LinkedBlockingQueue<Integer>();
	}

	public static void main(String[] args) {
		TaskHandler handler = new TaskHandler();
		new Thread(handler).start();
		for (int i = 1; i < 10; i++) {
			handler.addTask(i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Generated :" + i);
		}
	}

	public void run() {
		int id = 0;
		try {
			while ((id = blockingQueue.take()) != 0) {
				post(id);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
	}

	private void post(int id) {

		Lock lock = locHolder.get(id);
		lock.lock();
		System.out.println("Posting for:" + id);
		System.out.println("posted for" + id);
		System.out.println(locHolder.size() + "---" + blockingQueue.size());
		locHolder.remove(id);
		lock.unlock();

	}

	public void addTask(int id) {
		try {
			locHolder.put(id, new ReentrantLock());
			blockingQueue.put(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
