package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo19 {
	public static void main(String[] args) throws InterruptedException {
		A19 obj= new A19();
		Thread t1= new Thread(()-> obj.add());
		Thread t2=new Thread(()-> obj.add());
		t2.start();
		t1.start();
		t1.join();
		t2.join();
		System.out.println(obj.x.get());
	}
}


class A19{
	AtomicInteger x= new AtomicInteger();
	
	void add() {
		for(int i=0; i<10; i++)
		x.incrementAndGet();//x++
		
	}
}