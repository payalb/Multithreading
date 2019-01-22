package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Demo29 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<?> f1=service.submit(() -> IntStream.iterate(2, x -> x + 2)
										.limit(10)
										.forEach(System.out::println));
		Future<?> f2=service.submit(() -> IntStream.iterate(3, x -> x + 3)
				.limit(10)
				.forEach(System.out::println));
		Future<?> f3=service.submit(() -> IntStream.iterate(4, x -> x + 4)
				.limit(10)
				.forEach(System.out::println));
		Future<?> f4=service.submit(() -> IntStream.iterate(5, x -> x + 5)
				.limit(10)
				.forEach(System.out::println));
		Future<?> f5=service.submit(() -> IntStream.iterate(6, x -> x + 6)
				.limit(10)
				.forEach(System.out::println));
		
		f1.get();
		f2.get();
		f3.get();
		f4.get();
		f5.get();
		System.out.println("Done!");
		
		
	}
}
