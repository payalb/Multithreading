package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Runnable> queue= new ArrayBlockingQueue<>(4);
		ThreadPoolExecutor executor= new ThreadPoolExecutor(1, 2, 10, TimeUnit.MILLISECONDS,queue,Executors.defaultThreadFactory(),new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println("Rejected"+ r);
				
			}
		} );
		executor.submit(()-> {for(int i=1; i<=10; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=11; i<=20; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=21; i<=30; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=31; i<=40; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=41; i<=50; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=51; i<=60; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=61; i<=70; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=71; i<=80; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=81; i<=90; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=91; i<=100; i++) {System.out.println(i);}});
		executor.submit(()-> {for(int i=101; i<=110; i++) {System.out.println(i);}});
		executor.shutdown();
		executor.submit(()-> {for(int i=101; i<=110; i++) {System.out.println(i);}});
	//	executor.shutdownNow();
	}
}
