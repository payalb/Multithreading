package multithreading;

public class Demo3 {
	public static void main(String[] args) {
		Thread thread1= new Thread(new Task3(),"t1");
		thread1.start();
		Thread thread2= new Thread(new Task4(), "t2");
		thread2.start();
	}
}
class Task3 implements Runnable{
	@Override
	public void run() {
		for(int i= 1; i<=10; i++) {
			System.out.println(i);
		}
	}
}
class Task4 implements Runnable{
	@Override
	public void run() {
		for(int i= 11; i<=20; i++) {
			System.out.println(i);
		}
	}
}