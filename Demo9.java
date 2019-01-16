package multithreading;

public class Demo9 {
	public static void main(String[] args) {
		Worker worker1 = new Worker();
		Worker worker2 = new Worker();
		Thread t1 = new Thread(() -> worker1.add(),"t1");
		Thread t2 = new Thread(() -> worker2.add(),"t2");
		t1.start();
		t2.start();
	}
}
//2 threads cannot run in parallel
class Worker {
	static synchronized void add() { //class lock
		for(int i=0; i<=100; i++)
		System.out.println(Thread.currentThread().getName());
	}

}