package multithreading;

public class Demo11 {
	public static void main(String[] args) {
		Worker11 worker1 = new Worker11();
		Worker11 worker2 = new Worker11();
		Thread t1 = new Thread(() -> worker1.add(),"t1");
		Thread t2 = new Thread(() -> worker2.add(),"t2");
		Thread t3 = new Thread(() -> worker2.print(),"t3");
		Thread t4 = new Thread(() -> worker2.print(),"t4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
//t3 and t4 cannot run in parallel
class Worker11 {
	 synchronized void add() { //worker1//worker2
		for(int i=0; i<=100; i++)
		System.out.println(Thread.currentThread().getName());
	}

	 static synchronized void print() { //Class lock
		 for(int i=0; i<=100; i++)
				System.out.println("In printing");
	 }
}