package com.test.multithreading;

public class Test {
	
	public static void main(String[] args) throws Exception {
		Lock lock = new Lock();
		TestThread th1 = new TestThread(lock, "t1");
		TestThread2 th2 = new TestThread2(lock, "t2");
		new Thread(th1, "th1").start();
		new Thread(th2, "th2").start();
//		th2.run();
	}
	
}
