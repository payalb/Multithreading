package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Lock interface
public class Demo17 {
	public static void main(String[] args) {
		A17 obj = new A17();
		new Thread(() -> {
			try {
				obj.m1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t1").start();
		new Thread(() -> {
			try {
				obj.m1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t2").start();
	}
}

class A17 {
	int x;
	Lock lock= new ReentrantLock();
	void m1() throws InterruptedException {
		for (int i = 0; i < 10; i++) {//T1
			if(lock.tryLock(2000, TimeUnit.MILLISECONDS)) {//T1: lock
			System.out.println(x++);
			m2();
			lock.unlock();
			}else {
				Thread.sleep(1000);
			}
			
		}	
	}
	
	void m2() throws InterruptedException {
		if(lock.tryLock(2000, TimeUnit.MILLISECONDS)) {//lock +1
			System.out.println(++x);
			lock.unlock();
			}
			
		System.out.println("In m2");
		
	}
}