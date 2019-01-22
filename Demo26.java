package multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo26 {
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		executor.schedule(() -> {
			for (int i = 0; i <= 10; i++) {
				System.out.println(i + "; " + Thread.currentThread().getName());
			}
		}, 2, TimeUnit.MILLISECONDS);
		executor.schedule(() -> {
			for (int i = 11; i <= 20; i++) {
				System.out.println(i + "; " + Thread.currentThread().getName());
			}
		}, 3, TimeUnit.MILLISECONDS);
		executor.scheduleAtFixedRate(() -> {
			for (int i = 21; i <= 30; i++) {
				System.out.println(i + "; " + Thread.currentThread().getName());
			}
		}, 1, 2, TimeUnit.MILLISECONDS);
// 1 : 2: 2
		executor.scheduleWithFixedDelay(() -> {
			for (int i = 21; i <= 30; i++) {
				System.out.println(i + "; " + Thread.currentThread().getName());
			}
		}, 1, 2, TimeUnit.MILLISECONDS);
		//1: 2
	}
}
