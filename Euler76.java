import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Euler76 {

	private static List<int[]> pairs = new ArrayList<int[]>();
	
	public static void main(String[] args) {
		/*
		long t1= System.currentTimeMillis();
		int combinations = comb (10,1);
		long t2= System.currentTimeMillis();

		System.out.println("10: " + combinations + " for " + (t2-t1) + " ms");
		*/
		int N=100;
		
		long t1= System.currentTimeMillis();
		
		List<int[]> pairsN = getPairs(N);
		/*
		System.out.println("Expansion 9+1");
		getChildren(new int[]{9,1});
		System.out.println("Expansion 8+2");
		getChildren(new int[]{8,2});
		System.out.println("Expansion 7+3");
		getChildren(new int[]{7,3});
		System.out.println("Expansion 6+4");
		getChildren(new int[]{6,4});
		System.out.println("Expansion 8+1+1");
		getChildren(new int[]{8,1,1});
		System.out.println("Expansion 6+2+2");
		getChildren(new int[]{6,2,2});

		System.out.println("Expansion 10+4+1");
		getChildren(new int[]{10,4,1});

		System.out.println("Expansion 1+1+1");
		getChildren(new int[]{1,1,1});
		*/
	
		/*
		List<int[]> parents = pairsN;
		System.out.println("...Start: " + N);
	    int count = parents.size();    
		for (int l=3; l<=N; l++) {
			List<int[]> children = new ArrayList<int[]>();			
			for (int[] parent: parents) {
				//System.out.print("...parents: ");
				//printArray(parent);
				
			
				if (parent[0] < 2 || parent[0] < parent[1] +1) continue;
			    List<int[]> childrenP = getChildren(parent);
			    children.addAll(childrenP);
			}
			//parents=new ArrayList<int[]>();
			//parents.addAll(children);
			parents=children;
			count+=parents.size();
		}
	*/
	//	long t2= System.currentTimeMillis();
	//	System.out.println("Number of sums with >=2 terms = " + count +" for " + (t2-t1) + " ms");
        
		System.out.println("...Start: " + N);
		List<int[]> parents = pairsN;
		int count = parents.size();
		for (int[] parent: parents) {
		        count +=traverse(parent);
		}
		long t2= System.currentTimeMillis();
		System.out.println("Number of sums with >=2 terms = " + count +" for " + (t2-t1) + " ms");
		
		
		 t1= System.currentTimeMillis();
		 int combinations = comb (N,1);
		 t2= System.currentTimeMillis();

		System.out.println(N + ": " + combinations + " for " + (t2-t1) + " ms");
	}

	static int comb(int number, int min) {
		int temp = 1;
		//System.out.println("number: " + number + ", min: " + min);
		if (number <=2) return 1;
		for (int i=1; i <= Math.floor( ((double)number)/2.0); i++) {
		//	System.out.println("Before: " + number + ": i: " + i + ", temp: " + temp);
			if ( i >= min)
				  temp = temp +  comb(number - i, i);
		//	System.out.println("After: " + number + ": i: " + i + ", temp: " + temp);
		}
		return temp;
	}


	
	private static List<int[]> getChildren(int [] parent) {
		List<int[]> children = new ArrayList<int[]>();
		//for (int i=0; i < parent.length-1; i++) {
		//for (int i=0; i < parent.length/2; i++) {
		for (int i=0; i < 1; i++) {
			if (parent[i] < 2 || parent[i] < parent[i+1] +1) break;
			List<int[]> parentPairs = getPairs(parent[i]);
			for (int[] p: parentPairs) {
				if ( p[1] < parent[i+1] ) continue;
				int [] child = new int[parent.length+1];
				for (int j=0; j<=i-1;j++)
					child[j]=parent[j];
				child[i]=p[0];
				child[i+1]=p[1];
				for (int k=i+2;k<=parent.length;k++)
					child[k]=parent[k-1];
				children.add(child);
				// printArray(child);
			}			
           parentPairs = null; 
          // pairs.clear();
		}
		return children;
	}

	private static List<int[]> getPairs(int n) {
		List<int[]> pairs = new ArrayList<int[]>();
		for (int i=1; i <= Math.floor((double)n/2.0); i++) {
			int pair[] = new int[2];
			pair[0]=n-i; pair[1]= n -pair[0];
		    pairs.add(pair);
		    //System.out.println("......" + pair[0] +"+" +pair[1]);

		   // printArray(pair);
		}
		return pairs;
	}

	static void printArray(int[] a) {
		int i=0;
		for ( i = 0; i < a.length-1; i++)
		    System.out.print(a[i]+"+");
		System.out.println(a[i]);
	}
	
	private static int traverse (int[] parent) {
		List<int[]> children = getChildren(parent);
		int count = children.size();
		for (int[] child: children) {			
			count += traverse(child);
		}
		return count;
	}

}
