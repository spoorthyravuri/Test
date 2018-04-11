package com.test.multithreading;

public class TestThread implements Runnable {
	
	Lock lock = null;
	String name = null;
	
	public TestThread(Lock lock, String name) {
		this.lock = lock;
		this.name = name;
	}

	public void run() {
		System.out.println("start :: " +name);
		synchronized (lock) {
			System.out.println("lock :: " + name);
//			Thread.sleep(1000);
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("finished waiting :: "+name);
		}
		
	}
	
	public void testNotify() {
		synchronized(lock) {
			System.out.println("testNotify :: " +name);
			lock.notifyAll();
		}
	}

}
