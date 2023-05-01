package sorting.simple;

import java.util.Arrays;

import sorting.SorterBase;

public class ShellSort extends SorterBase
{
	@Override
	public void sort(Comparable[] target) {
		int i, j, h = 1, n = target.length;
		while (h <= n / 3) {
			h = (3 * h) + 1;
		}
		while (h >= 1) {
			for (i = h; i < n; i++) {
				for (j = i; j >= h  && less(target[j],target[j-h]); j -= h) {
					swap(target,j,j-h);
				}
			}
			h=h/3;
		}
	}

	/*
	    public static char[] shellSort(char[] list){
        int i,j,h=1,n=list.length;
        char temp;

        while(h<=n/3) {
            h =  (3 * h) + 1;}
            while(h>0){
                for (i=h; i<n;i++){
                    temp=list[i];
                    for(j=i;j>h-1 && list[j-h]>=temp;j-=h){
                        list[j]=list[j-h];
                        list[j-h]=temp;
                    }
                }
                h=h/3;
            }
        return list;
    }
	 */
	
}
