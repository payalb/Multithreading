package multithreading;

public class Demo7 {
public static void main(String[] args) {
	Worker worker= new Worker();
	Thread t1= new Thread(()->worker.add());
	Thread t2= new Thread(()->worker.print());
	Thread t3= new Thread(()->worker.add());
	t1.start();t2.start();t3.start();
}
}

/*class Worker{
	
	int a;
	
	synchronized void add() {//t1 //t3 //t1
		a++;//a+1   //assign a
	}//release the lock
	
	void print() {//t2
		System.out.println(a);//read
	}
}*/