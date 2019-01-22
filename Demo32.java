package multithreading;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class Demo32 {
	public static void main(String[] args) {
		int[] numbers = { 2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12 };//descending : frequency
		Map<Integer, Integer> map = new TreeMap<>();
		for (Integer no : numbers) {
			if (map.containsKey(no)) {
				map.put(no, map.get(no) + 1);
			} else {
				map.put(no, 1);
			}
		}
		System.out.println(map);

		MyComparator comp= new MyComparator();
		Set<Entry<Integer, Integer>> set= new TreeSet<>(comp);
		set.addAll(map.entrySet());
		List<Integer> result=set.stream().flatMap(x-> {
			Builder<Integer> builder= Stream.builder();
			for(int i=0; i<x.getValue(); i++) {
			builder.add(x.getKey());
			}
			return builder.build();
		}).collect(Collectors.toList());
		System.out.println(result);
	}
}

class MyComparator implements Comparator<Entry<Integer, Integer>>{

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		if(o1.getValue()==o2.getValue()) {
			return o1.getKey()-o2.getKey();
		}
		return o2.getValue()-o1.getValue();
		//>0: later, <0, before ==0: equal
	}
	
}
