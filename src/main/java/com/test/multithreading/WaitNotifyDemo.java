package com.test.multithreading;

import java.util.Date;
import java.util.Random;

public class WaitNotifyDemo {
	
	public static void main(String[] args) {
		
		new WaitNotifyDemo().process();
		
	}
	
	public void process() {
		
		SharedClass shared = new SharedClass();
		new Thread(new TestClass(shared, 2000, 500)).start();
		Thread t2 = new Thread(new Test(shared, 2000));
		t2.start();
		t2.interrupt();
		
	}
	
	class TestClass implements Runnable {
		
		private SharedClass shared;
		private long sleepTime;
		private long waitTime;
		
		public TestClass(SharedClass shared, long sleepTime, long waitTime) {
			this.shared = shared;
			this.sleepTime = sleepTime;
			this.waitTime = waitTime;
		}

//		@Override
		public void run() {
			synchronized(shared) {
				try {
					System.out.println(Thread.currentThread().getId()+" TestClass 1: " + new Date().getTime());
					Thread.sleep(sleepTime);
					shared.notifyAll();
					shared.wait(waitTime);
					System.out.println("=============");
					System.out.println(Thread.currentThread().getId()+" TestClass 2: " + new Date().getTime());
					System.out.println(Thread.currentThread().getId()+" TestClass: " + shared.getRandom());
					System.out.println(Thread.currentThread().getId()+" TestClass 3: " + new Date().getTime());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	class Test implements Runnable {
		private SharedClass shared;
		private long sleepTime;
		
		public Test(SharedClass shared, long sleepTime) {
			this.shared = shared;
			this.sleepTime = sleepTime;
		}

//		@Override
		public void run() {
			synchronized (shared) {
				try {
					System.out.println(Thread.currentThread().getId()+" Test: " + shared.getRandom());
					System.out.println(Thread.currentThread().getId()+" Test 1: " + new Date().getTime());
					Thread.sleep(sleepTime);
					System.out.println(Thread.currentThread().getId()+" Test 2: " + new Date().getTime());
					shared.notifyAll();
					System.out.println(Thread.currentThread().getId()+" Test 3: " + new Date().getTime());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	class SharedClass {
		
		private Random random = null; 
		
		public SharedClass() {
			random = new Random();
		}
		
		public int getRandom() {
			return random.nextInt();
		}
	}
}
