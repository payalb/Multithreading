package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo15 {
	public static void main(String[] args) {
		MyList obj = new MyList();
		new Thread(new Runnable() {
			public void run() {
				obj.add();
			}
		}, "t1").start();

		// new Thread(() -> obj.add(), "t1").start();
		new Thread(() -> obj.add(), "t2").start();
	}
}

class MyList {
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	Object lock1 = new Object();
	Object lock2 = new Object();

	public void add() {
		for (int i = 0; i < 10; i++) {
			Random obj = new Random();
			synchronized (lock1) {//T1, T2
				list1.add(obj.nextInt(100));//T1 timeup
			}
			synchronized (lock2) {
				list2.add(obj.nextInt(200));
			}

			System.out.println(Thread.currentThread().getName());
		}
	}
//basics
}