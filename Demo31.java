package multithreading;

import java.util.PriorityQueue;
import java.util.Random;

public class Demo31 {
	public static void main(String[] args) {
		//BlockingQueue: Fixed size: 10
		//no null
		//comparable, comparator
		/*PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.offer(new Random().nextInt(100));
		}
		for(int i=0;i< 10; i++) {
		System.out.println(queue.poll());
		}*/
		
		//store elements in any order: poll(): ascending
		PriorityQueue<Employee> queue1 = new PriorityQueue<>();
		queue1.add(new Employee(1, "Payal"));
		queue1.add(new Employee(2, "Amrita"));
		queue1.add(new Employee(3, "Payal"));
		queue1.add(new Employee(4, "Ritu"));
		queue1.add(new Employee(5, "Kanika"));
		
		for(int i=0; i<5; i++) {
		System.out.println(queue1.poll());
		}
	}
		//queue.stream().forEach(System.out::println);
}

class Employee implements Comparable<Employee>{
	int id;
	String name;
	
	Employee(int id, String name){
		this.id= id;
		this.name= name;
	}
	@Override
	public int compareTo(Employee o) {
		if(name.equals(o.name)) {
			return this.id-o.id;
		}else {
		return this.name.compareTo(o.name);
		}
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}
// Input:2,3,2,4,5,12,2,3,3,3,12: decreasing order of freq
// Output:3 3 3 3 2 2 2 12 12 4 5
 // This is for priority queue: 2 2 2 3 3 3 3 4 5 12 12 
