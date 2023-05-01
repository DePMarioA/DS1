package sorting.advanced;
import java.lang.annotation.Target;
import java.security.Key;
import java.util.Arrays;
import java.util.PriorityQueue;

import sorting.Sorter;

public class HeapSort implements Sorter {
	@Override
	public void sort(Comparable[] target) {
		PriorityQueue<Comparable> heap = new PriorityQueue<>();
		for (int i = 0; i < target.length; i++) {
			heap.add(target[i]);
		}
		int k=0;
		while (!heap.isEmpty()){
			target[k]=heap.remove();
			k++;
		}
	}
}