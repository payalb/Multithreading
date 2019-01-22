package multithreading;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Demo22 {
	public static void main(String[] args) {
		Queue<Integer> q= new ArrayBlockingQueue<>(10);//Producer Consumer
		
		for(int i=0; i<12; i++) {
			q.offer(i);
		}
		Iterator it=q.iterator();
		
		while(it.hasNext()) {
		//	System.out.println(it.);
		System.out.println(q.peek());
		q.poll();
		it.next();
	//	q.
		}
		System.out.println(q.size());
		
		/*q.add(10);
		q.add(20);
		q.offer(30);
		q.remove();
		q.remove();
	//	q.remove();//NoElementException
	//	q=null;
		//q.remove();//NUllPointerException
		System.out.println(q);
		
		q.poll();//remove, null if the queue is empty
*/	}
}
// 1