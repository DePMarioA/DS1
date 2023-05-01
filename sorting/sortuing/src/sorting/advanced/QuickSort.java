package sorting.advanced;

import java.util.Arrays;

public class QuickSort extends QuickSortBase {
	@Override
	public void sort(Comparable[] target) {
		shuffle(target);
		sort_(target, 0, target.length - 1);
	}

	private void sort_(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort_(a, lo, j - 1);
		sort_(a, j + 1, hi);
	}

	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v)) {
				if (i == hi) {
				    break;
				}
			}
			while (less(v, a[--j])){
				if (j == lo) {
					break;
				}
			}
			if (i >= j){
				break;
			}
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}
}