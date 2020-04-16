package com.ljp.test.thread;

import java.util.concurrent.TimeUnit;

public class ThreadAliveTest {

//	static double a;
//	static float b;
//	static byte c;
//	static short d;
//	static int ee;
//	static boolean f;
//	static long g;

	public static void main(String[] args) {
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
//		System.out.println(ee);
//		System.out.println(f);
//		System.out.println(g);
		Thread thread = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(thread.isAlive());
	}

}
