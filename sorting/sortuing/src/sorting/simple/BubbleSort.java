package sorting.simple;

import java.util.Arrays;

import sorting.SorterBase;

public class BubbleSort extends SorterBase 
{
	@Override
	public void sort(Comparable[] target) 
	{
		int i, j,n=target.length;

		for (i=0;i<n-1; i++) {
			for (j = (n - 1); j != i; j--) {
				if (less(target[j],target[i])){
					swap(target,i,j);
				}
			}
		}
	}
}

/*
public static char[] bubbleSort2(char[] list){
        int i,j;
        char temp;
        for (i=0;i<list.length-1; i++){
            for(j=(list.length-1);j!=i;j--){
                if(list[j]<list[j-1]){
                    temp = list[j];
                    list[j]=list[j-1];
                    list[j-1]=temp;
                }
            }
        }
        return list;
}
 */
