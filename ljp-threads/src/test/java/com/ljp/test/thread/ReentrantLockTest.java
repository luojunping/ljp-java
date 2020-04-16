package com.ljp.test.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	static ReentrantLock reentrantLock = new ReentrantLock();

	public static void main(String[] args) {
		ReentrantLockTest r1 = new ReentrantLockTest();
		ReentrantLockTest r2 = new ReentrantLockTest();
		System.out.println(r1.reentrantLock == r2.reentrantLock);
		new Thread(() -> {
			r1.lock();
		}).start();
		new Thread(() -> {
			r2.lock();
		}).start();
		System.out.println(r1.reentrantLock);
		System.out.println(r2.reentrantLock);
		System.out.println(null == null);
	}

	public void lock() {
		try {
			reentrantLock.lock();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hahaha");
		} finally {
			reentrantLock.unlock();
		}
	}
}
