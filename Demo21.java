package multithreading;

public class Demo21 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1= new Thread(new Tasks1());
		t1.start();//runnable
		//scheduler : schedule : running: run()
		//after run: dead();
		t1.join();//dead
		t1.start();
	}
}

//Pool of threads: 2
//5 tasks: 


//Thread: 1 task -> 2 task

class Tasks1 implements Runnable{
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println("2 *" + i +"= "+ (2*i));
		}
	}
}

class Tasks2 implements Runnable{
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println("3 *" + i +"= "+ (3*i));
		}
	}
}