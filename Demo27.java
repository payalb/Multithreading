package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo27 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		ExecutorService service = Executors.newCachedThreadPool();
		Future<Double> future=service.submit(new Callable<Double>() {
//Future will not wait for thread to finish execution
			@Override
			public Double call() throws Exception {
				System.out.println("Started task");
				Thread.sleep(2000);
				double d = Math.random();
				System.out.println("about to finish task");
				return d;
			}
			
		});
		System.out.println(future);
		System.out.println("In main");
		Double d=future.get(); //It is going to wait to get the result of the task
		System.out.println(d);
	}
}
