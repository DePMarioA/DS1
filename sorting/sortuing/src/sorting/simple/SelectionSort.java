package sorting.simple;

import java.util.Arrays;

import sorting.SorterBase;

public class SelectionSort extends SorterBase 
{
	@Override
	public void sort(Comparable[] target)
	{
		int i, j,n=target.length,min;
		for (i=0;i<n; i++) {
			min=i;
			for (j=i+1;j<n;j++){
				if (less(target[j],target[min])){
					min=j;
				}
			}
			swap(target,i,min);
		}
	}
}
/*
    public static char[] selectionSort(char[] list){
        int i,j,min;
        char temp;
        for (i=0;i<list.length; i++){
            min=i;
            for(j=i+1;j<list.length;j++){
                if(list[min]>list[j]) {
                    min=j;
                }
            }
            temp = list[i];
            list[i]=list[min];
            list[min]=temp;
        }
        return list;
    }
 */
