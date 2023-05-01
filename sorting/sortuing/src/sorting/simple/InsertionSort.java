package sorting.simple;

import java.util.Arrays;

import sorting.SorterBase;

public class InsertionSort extends SorterBase 
{
	@Override
	public void sort(Comparable[] target) 
	{
		int i, j,n=target.length;
		for (i=1;i<n; i++) {
			for (j=i;j>0&&less(target[j],target[j-1]);j--){
				swap(target,j,j-1);
			}
		}
	}
}
/*
    public static char[] InsertionSort(char[] list){
        int i=1,j=1;
        int k;
        char temp;
        for (i=1;i<=list.length-1; i++) {
            j = i;
            for(j=i;j>0;j--)
                if (list[j] <= list[j - 1]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
            }
        }

        return list;
    }
 */