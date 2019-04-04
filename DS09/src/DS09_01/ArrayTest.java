package DS09_01;

import java.util.*;

public class ArrayTest {
	private int[] a;	private int size; //
		
	public ArrayTest(int s) {
		Random rd = new Random();
		a = new int[s];
		for(int i=0;i<a.length;i++) {
			a[i] = rd.nextInt(100);
		}			
		size = a.length;
			
	}
	public void removemultiples(int x) {
		int index=0; int count =0;

		for(int i=0;i<a.length;i++) {
			if(a[i]%x==0) {
				count++;
			}
		}
		size = a.length - count;
		while(count>0) {
			for(int i=0;i<a.length;i++) {
				if(a[i]%x==0) {
					index = i;	count --;	break;
				}
			}
			for(int k=index;k<a.length-1;k++) {
					a[k] = a[k+1]; 
					a[k+1] = 0;
				}
		}
			
	}
	public void doublelength() {
		int[] b;
		b = new int[a.length*2];
		System.arraycopy(a, 0, b, 0, size);
		a = b;
			
	}
	public void print() {
		for(int i=0;i<a.length;i++) {
			if(a[i]!=0)	System.out.print(a[i]+" ");
		}
		System.out.println("  |   배열의 크기: " + a.length);
		
		}
	}
