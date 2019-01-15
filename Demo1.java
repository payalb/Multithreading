package multithreading;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException {
		MyList obj = new MyList();
		Thread t1 = new Thread(()-> obj.add());
		t1.start();
		Thread t2 = new Thread(()-> obj.remove());
		t2.start();
		t1.join();
		t2.join();
		System.out.println(obj.size());
	}
}

class MyList {
	Object lock= new Object();
	List<Double> list= new ArrayList<>();

	public void add() {
		for (int i = 0; i < 200; i++) {
			synchronized (lock) {
				list.add(Math.random());
			}
		}
	}
	public void remove() {
		for(int i=0; i<200; i++) {
			synchronized (lock) {
				list.remove(0);
			}
		}
	}

	int size() {
		return list.size();
	}

}