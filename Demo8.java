package multithreading;

public class Demo8 {
	public static void main(String[] args) {
		Worker worker1 = new Worker();
		Worker worker2 = new Worker();
		Thread t1 = new Thread(() -> worker1.add());
		Thread t2 = new Thread(() -> worker1.print());
		Thread t3 = new Thread(() -> worker2.add());
		t1.start();
		t2.start();
		t3.start();
	}
}
//All threads can run in parallel
/*class Worker {
	int a;
	synchronized void add() { //worker1  //t1 //worker2
		a++;//a+1 //timeup
	}
	synchronized  void print() { //race condition//t2
		System.out.println(a);
	}
}*/