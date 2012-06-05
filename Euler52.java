import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Euler52 {
	
	private static List<int[]> cyclicN= new ArrayList<int[]>();
	
	public static void main(String [] args) {
		//comb4();
		long t1 = System.currentTimeMillis();
		int[] a= new int[]{1,0,0,0,0,0};
		int limits[] = new int[]{1,6,6,9,9,9};
		//comb4A(a,  0,  limits);
		comb4B(a,  0,  limits);
		System.out.println("==== Cyclic Numbers==========");
		for (int[] ccl: cyclicN) {	       
			printArray(ccl);
			if (checkProdN(ccl, 2) && checkProdN(ccl, 3) && checkProdN(ccl, 4) && checkProdN(ccl, 5))
				System.out.println("======= The NUMBER =========");
				
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Runtime:" + (t2 -t1));
	}
	
	
	private static void comb4() {
		int[] a= new int[]{1,0,0,0};
		
		for (int i = 0;i <6;i++) {
			a[1]++; a[2]=0;
			for (int j = 0;j <6;j++) {
				a[2]++; a[3]=0;
				for (int k = 0;k <6;k++) {
					a[3]++;
					printArray(a);
					checkProdN(a, 6);
				}	
			}			
		}
	}
	
	private static void comb4A(int[] a, int k, int[] limits) {		
		System.out.print(k + ": ");
		
		printArray(a);
		
		if (k > a.length-1) return;
		
		List<int[]> children = new ArrayList<int[]>();
		int[] a1 = Arrays.copyOf(a, a.length);
		children.add(a1);	

		while (a[k] <limits[k]) {
			a[k]++;
			a1 = Arrays.copyOf(a, a.length);
			children.add(a1);			
		}
		
		for (int [] arr: children) {
		    comb4A(arr, k +1,  limits);	
		}
	}
	
	private static void comb4B(int[] a, int k, int[] limits) {		
	//	System.out.print(k + ": ");		
	//	printArray(a);
		
		if (k > a.length-1) return;
		
		List<int[]> children = new ArrayList<int[]>();
		int[] a1 = Arrays.copyOf(a, a.length);
		children.add(a1);	

		while (a[k] <limits[k]) {
			a[k]++;
			a1 = Arrays.copyOf(a, a.length);
			children.add(a1);			
		}
		
		for (int [] arr: children) {
			System.out.print(k + ": ");		
			printArray(arr);
			boolean isCyclic = checkProdN(arr, 6);
			if (isCyclic) {
		//		System.out.println("********* Cyclic Number:");
			    cyclicN.add(arr);
			}
		    comb4B(arr, k +1,  limits);	
		}
	}
	
	
	private static boolean checkProdN(int[] a, int n) {
		boolean isCyclic = true;
		int [] a1=Arrays.copyOf(a, a.length);
		int [] a2=Arrays.copyOf(a, a.length);
		int carry = 0;
		for (int i= a.length-1 ; i>=0; i--) {
			  a1[i] = a1[i]*n + carry;
			 carry = a1[i]/10;
			 a1[i] = a1[i]%10;
		}
		//System.out.print("*****"); printArray(a1);
		Arrays.sort(a1);
		Arrays.sort(a2);
		for (int i=0; i< a1.length; i++) {
			if (a1[i] !=a2[i]) isCyclic = false;
		}
		
		return isCyclic;
	}

	
	private static void printArray(int[] a) {
		int i=0;
		for ( i = 0; i < a.length-1; i++)
		    System.out.print(a[i]+",");
		System.out.println(a[i]);
	}
	
	/*
	 public static void doAnagram(int newSize, int[] array) {
		    int limit;
		    if (newSize == 1) // if too small, return;
		      return;
		    // for each position,
		    for (int i = 0; i < newSize; i++) {
		      doAnagram(newSize - 1, array); // anagram remaining
		      if (newSize == 2) // if innermost,
		    	  printArray(array); 
		      rotate(newSize, array, array.length); // rotate word
		    }
		  }

		  // rotate left all chars from position to end
		  public static void rotate(int newSize, int[] array, int size) {
		    int i;
		    int position = size - newSize;
		    // save first letter
		    int temp = array[position];
		    //shift others left
		    for (i = position + 1; i < size; i++)
		    	array[i - 1] = array[i];
		    //put first on right
		    array[i - 1] = temp;
		  }
  */
}
