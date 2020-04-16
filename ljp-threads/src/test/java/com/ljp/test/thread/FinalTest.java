package com.ljp.test.thread;

import java.util.concurrent.TimeUnit;

public class FinalTest {

	int i;
	final int j;
	static FinalTest obj;

	public FinalTest() {
		i = 1;
		j = 2;
		obj = this;
	}

	public static void writer() {
//		obj = new FinalTest();
		new FinalTest();
	}

	public static void reader() {
		FinalTest object = obj;
		int a = object.i;
		int b = object.j;
		System.out.println(a);
		System.out.println(b);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				FinalTest.reader();
			}).start();
//			try {
//				TimeUnit.MILLISECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			new Thread(() -> {
				FinalTest.writer();
			}).start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println("=======================");
		}
	}

}
