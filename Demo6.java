package multithreading;

public class Demo6 {
	public static void main(String[] args) throws InterruptedException {
		Work obj= new Work();
		Thread t1= new Thread(obj);
		Thread t2= new Thread(obj);
		t1.start();
		t2.start();
		//Main thread to wait till t1 and t2 have finished execution
		t1.join();//t1 would be done. main wait
		t2.join(); //t2 is done : main will go to next line
		System.out.println(obj.a); //20
	}
}

class Work implements Runnable{
	int a;
//lock : object lock: thread
	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			a++; //a+1: wait: T2
		}
	}
	//unlock
}