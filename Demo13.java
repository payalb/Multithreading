package multithreading;

public class Demo13 {
	public static void main(String[] args) {
		new Thread(() -> A13.m1(), "t1").start();
		new Thread(() -> A13.m1(), "t2").start();
	}
}

class A13 {
	
	static int count;

	static void m1() {
		for (int i = 0; i < 10; i++) {
			synchronized (A13.class) {
				System.out.println(count++ + " ; " + Thread.currentThread().getName());
			}
		}
	}
}