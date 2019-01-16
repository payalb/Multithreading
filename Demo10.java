package multithreading;

public class Demo10 {
	public static void main(String[] args) {
		Worker10 worker1 = new Worker10();
		Worker10 worker2 = new Worker10();
		Thread t1 = new Thread(() -> worker1.add(),"t1");
		Thread t2 = new Thread(() -> worker2.add(),"t2");
		Thread t3 = new Thread(() -> worker2.print(),"t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
//All 3 in parallel
class Worker10 {
	 synchronized void add() { //worker1//worker2
		for(int i=0; i<=100; i++)
		System.out.println(Thread.currentThread().getName());
	}

	 static synchronized void print() { //Class lock
		 for(int i=0; i<=100; i++)
				System.out.println("In printing");
	 }
}