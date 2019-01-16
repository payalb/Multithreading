package multithreading;

public class Demo12 {
	public static void main(String[] args) throws InterruptedException {
		Worker12 worker1 = new Worker12();
		Thread t1 = new Thread(() -> worker1.add());
		Thread t2 = new Thread(() -> worker1.add());
		t1.start();
	//	Thread.sleep(2000);
		t2.start();
		t1.join();
		t2.join();
		System.out.println(worker1.a);
	}
}

class Worker12 {
	int a;//instance
	 void add() {
		int count=0;
		for (int i=0; i < 100; i++) {
			count++;
			synchronized(this) {
				a++;//a+1: a=value//t1
			}
		}
		System.out.println(count);
	}

}