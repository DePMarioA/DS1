package sorting.advanced;

import sorting.Sorter;

public class MergeSort implements Sorter 
{
	private  Comparable[] targetCopy;
	@Override
	public void sort(Comparable[] target) 
	{
		targetCopy =new Comparable[target.length];
		sort_(target,0,target.length-1);
	}

	public void merge(Comparable[] a , int lo, int mid, int hi){
		int i = lo, j= mid+1;
		for(int k = lo; k<=hi;k++){
			targetCopy[k] = a[k];
		}
		for( int k = lo; k<= hi; k++){
			if(i>mid){
				a[k]= targetCopy[j++];
			}
			else if(j>hi){
				a[k]= targetCopy[i++];
			}
			else if(less(targetCopy[j], targetCopy[i])){
				a[k]= targetCopy[j++];
			}
			else{
				a[k]= targetCopy[i++];
			}
		}

	}
	protected boolean less(Comparable me, Comparable other)
	{
		return me.compareTo(other) < 0;
	}

	private void sort_(Comparable[] a, int lo, int hi){
		if(hi<=lo){return;}
		int mid = lo + (hi - lo)/2;
		sort_(a,lo,mid);
		sort_(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
}