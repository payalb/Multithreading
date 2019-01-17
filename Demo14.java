package multithreading;

public class Demo14 {
	public static void main(String[] args) {
		A14 obj = new A14();
		new Thread(() -> obj.print(), "t1").start();
		new Thread(() -> obj.print(), "t2").start();
		obj.a= 5;
	}
}

class A14 {

	int a = 5;
//Lock on immutable objects
	Object lock= new Object();
	public void print() {
		for (int i = 0; i < 10; i++) {
			synchronized (lock) {
				System.out.println(a++);
			}
		}
	}
}


