package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo16 {
	public static void main(String[] args) {
		MyList1 obj = new MyList1();
		new Thread(() -> {
			try {
				obj.add1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t1").start();
		new Thread(() -> {
			try {
				obj.addAtIndex0();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t2").start();
	}
}

class MyList1 {
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	Object lock1 = new Object();
	Object lock2 = new Object();

	public void add1() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Random obj = new Random();
			synchronized (lock2) {// T1
				Thread.sleep(1000);
				synchronized (lock1) {
					list1.add(list2.get(0));// T1 timeup
				}
				list2.add(obj.nextInt(200));
			}
			System.out.println(Thread.currentThread().getName());
		}
	}

	public void addAtIndex0() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
		Random obj = new Random();
		synchronized (lock2) {
			Thread.sleep(1000);
		
				synchronized (lock1) {//T2
				list1.add(list2.get(0));// T1 timeup
			}
			list1.add(obj.nextInt(200));
		}
		}
	}
//basics
}