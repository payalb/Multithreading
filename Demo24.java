package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo24 {
	public static void main(String[] args) {
	Executor executor=	Executors.newCachedThreadPool();
	executor.execute(()-> { for(int i=0; i<=10; i++) {System.out.println(i+ "; "+ Thread.currentThread().getName());}});
	executor.execute(()-> { for(int i=11; i<=20; i++) {System.out.println(i+ "; "+ Thread.currentThread().getName());}});
	executor.execute(()-> { for(int i=21; i<=30; i++) {System.out.println(i+ "; "+ Thread.currentThread().getName());}});
	executor.execute(()-> { for(int i=31; i<=40; i++) {System.out.println(i+ "; "+ Thread.currentThread().getName());}});
	executor.execute(()-> { for(int i=41; i<=50; i++) {System.out.println(i+ "; "+ Thread.currentThread().getName());}});
	executor.execute(()-> { for(int i=51; i<=60; i++) {System.out.println(i+ "; "+ Thread.currentThread().getName());}});
	executor.execute(()-> { for(int i=61; i<=70; i++) {System.out.println(i+ "; "+ Thread.currentThread().getName());}});
	executor.execute(()-> { for(int i=71; i<=80; i++) {System.out.println(i+ "; "+ Thread.currentThread().getName());}});
	}
}
