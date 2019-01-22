package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class Demo28 {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor=Executors.newFixedThreadPool(3);
		Future<Integer> f1=executor.submit(()-> IntStream.range(1, 10).sum());
		Future<Integer> f2=executor.submit(()-> IntStream.range(11, 20).sum());
		Future<Integer> f3=executor.submit(()-> IntStream.range(21, 30).sum());
		Future<Integer> f4=executor.submit(()-> IntStream.range(31, 40).sum());
		Future<Integer> f5=executor.submit(()-> IntStream.range(41, 50).sum());
		Future<Integer> f6=executor.submit(()-> IntStream.range(51, 60).sum());
		Future<Integer> f7=executor.submit(()-> IntStream.range(61, 70).sum());
		Future<Integer> f8=executor.submit(()-> IntStream.range(71, 80).sum());
		Future<Integer> f9=executor.submit(()-> IntStream.range(81, 90).sum());
		Future<Integer> f10=executor.submit(()-> IntStream.range(91, 100).sum());
		
		Integer sum=f1.get(2000,TimeUnit.MILLISECONDS)+ f2.get(2, TimeUnit.SECONDS)+ f3.get()+ f4.get()+
		f5.get()+ f6.get()+ f7.get()+ f8.get()+ f9.get()+ f10.get();
		System.out.println(sum);
	}
}
