package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo18 {
public static void main(String[] args) {
	
}
}// T1: add, T2: add, T3: print, T4: print, T5: add
//Read: No write| Yes read
//Write: No read/ write
class A18{
	ReadWriteLock lock= new ReentrantReadWriteLock();
Lock lockRead= new ReentrantLock();
	int x;
	public void m1() throws InterruptedException {
		for(int i=0;i<10;i++) {
			if(lock.writeLock().tryLock(2000, TimeUnit.MILLISECONDS)){
				x++;
				lock.writeLock().unlock();
			} else {
				Thread.sleep(1000);
				i--;
			}
			
		}
	}
	
	
	public void print() throws InterruptedException {
		if(lock.readLock().tryLock(2000, TimeUnit.MILLISECONDS)){
		System.out.println(x);
		lock.readLock().unlock();
		}
		
	}
}