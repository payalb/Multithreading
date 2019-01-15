package multithreading;

public class Demo4 {
	public static void main(String[] args) throws InterruptedException {
			Task obj= new Task();
			Thread thread1= new Thread(new Runnable() {
				public void run() {
					obj.print1();
				}
					
			});
				
			Thread thread2= new Thread(new Runnable() {
				public void run() {
					obj.print2();
				}
					
			});
			thread1.start();
			thread2.start();
			//main thread to wait till thread1 finishes it's task
			thread1.join();
			//main thread to wait till thread2 finishes it's task
			thread2.join();
			System.out.println(obj.count+ "**");//0
	}
}


class Task{
	int count;
	void print1() {
		for(int i=1; i<=100; i++) {
			count++;
		}
	}
	
	void print2() {
		for(int i=101; i<=200; i++) {
			count++;
		}
	}
}