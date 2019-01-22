package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Demo30 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(2);
		//Timeout for pool
		service.awaitTermination(2000, TimeUnit.MILLISECONDS);
		service.submit(() -> IntStream.iterate(2, x -> x + 2).limit(10).forEach(System.out::println));
		service.submit(() -> IntStream.iterate(3, x -> x + 3).limit(10).forEach(System.out::println));
		service.submit(() -> IntStream.iterate(4, x -> x + 4).limit(10).forEach(System.out::println));
		service.submit(() -> IntStream.iterate(5, x -> x + 5).limit(10).forEach(System.out::println));
		service.submit(() -> IntStream.iterate(6, x -> x + 6).limit(10).forEach(System.out::println));
	//	service.shutdown(); //Cannot accept any new tasks now. But will wait for all threads to finish execution
		service.submit(()-> System.out.println("Task7"));
		service.shutdownNow();//Forcefully do a shutdown. Terminate any running thread
	}
}
//queue: fifo: peek, poll, offer, remove, add,get