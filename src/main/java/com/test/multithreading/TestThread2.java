package com.test.multithreading;

public class TestThread2 implements Runnable {
	
	Lock lock = null;
	String name = null;
	
	public TestThread2(Lock lock, String name) {
		this.lock = lock;
		this.name = name;
	}

	public void run() {
		System.out.println("start :: " +name);
		synchronized (lock) {
//			try {
				System.out.println("Run :: " + name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Notifying :: " + name);
				lock.notify();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
	}
}
