package multithreading;

public class Demo2 {
	public static void main(String[] args) {
			Task1 thread1= new Task1();
			thread1.start();
			Task2 thread2= new Task2();
			thread2.start(); //user threads
			//Ur main thread will not terminate till both have finished the task
	}
}


class Task1 extends Thread{
	//task to do
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(i +" * 2 = "+ (i*2));
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class Task2 extends Thread{
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(i +" * 3 = "+ (i*3));
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}
//2 threads : 2 | 3