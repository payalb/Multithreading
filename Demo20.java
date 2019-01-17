package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo20 {
	public static void main(String[] args) throws InterruptedException {
		MList obj= new MList();
		Thread t1= new Thread(()-> {
			try {
				obj.add();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2= new Thread(()-> {
			try {
				obj.remove();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(obj.list.size());
	}
}

class MList {
	Lock lock = new ReentrantLock();
	List<Double> list = new ArrayList<>(20);//20

	void add() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			if (lock.tryLock()) {
				while(list.size()>=20) {
					lock.wait();
				}
				list.add(Math.random());//20
				lock.notify();//signal: waiting: runnable
				lock.unlock();
			} else {
				i--;
			}
		}
	}
	//Producer Consumer

	void remove() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			if (lock.tryLock()) {
				while(list.size()<1) {
					lock.wait();//wait: synchronized/lock
				}
				list.remove(0);
				lock.notify();
				lock.unlock();
			} else {
				i--;
			}
		}
	}
}