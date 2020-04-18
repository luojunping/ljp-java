package com.ljp.test.thread;

import java.util.concurrent.TimeUnit;

public class ThreadRepeatTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("ThreadRepeatTest...");
		}, "ThreadRepeatTest");
		t1.start();
		TimeUnit.MICROSECONDS.sleep(1);
		System.out.println(t1.isAlive());
		t1.run();
	}

}

class RepeatThread extends Thread {

	@Override
	public void run() {
		super.run();
		System.err.println("Hello World !!!");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
