package multithreading;

import java.time.LocalDateTime;

public class Demo5 {
	public static void main(String[] args) throws InterruptedException { // main thread
		Thread t1= new Thread(new Task1());
		t1.setPriority(Thread.MAX_PRIORITY);
		
		Task2 t2=new Task2();
		t2.setPriority(9);
		t2.setDaemon(true); //background
		t2.start();//jvm allocate all the resources needed for it to run: runnable
		t1.start();//runnable: : schedule: running: run method
		//user thread, daemon thread
		Thread.sleep(2000); //
		System.out.println("2 sec done!");
	//Word: typing: grammar, formatting: background tasks, processor: print
		//schedule will schedule t
		
	//main thread will wait for all user threads to finish execution, 
		//it will not wait for daemon threads to finish execution
		
		//Garbage collection: heap : deallocating the memory : daemon //RAM
	}
	
}



class Task1 implements Runnable{
	@Override
	public void run() {
		for(int i=1; i<=10000; i++)
		System.out.println(i);
		
	}
}
class Task2 extends Thread{
	@Override
	public void run() {
		while(true) {
		System.out.println(LocalDateTime.now());
		}
	}
}