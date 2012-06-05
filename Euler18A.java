import java.util.ArrayList;
import java.util.List;


public class Euler18A {
   //private static int s[] = {3,7,4,2,4,6,8,5,9,3};

	private static int s[] = {
		75,
		95, 64,
		17, 47, 82,
		18, 35, 87, 10,
		20, 04, 82, 47, 65,
		19, 1, 23, 75, 3, 34,
		88, 2, 77, 73, 7, 63, 67,
		99, 65, 4, 28, 6, 16, 70, 92,
		41, 41, 26, 56, 83, 40, 80, 70, 33,
		41, 48, 72, 33, 47, 32, 37, 16, 94,29,
		53, 71, 44, 65, 25,43 ,91, 52 ,97 ,51, 14,
		70 ,11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57,
		91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48,
		63, 66, 4, 68, 89, 53, 67, 30,73, 16, 69, 87,40, 31,
		4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23};

	
	private static int rows =0;
    private static int [][] triangle;// = new int[len][len];
	
	public static void main(String [] args) {	
		rows = (int) (Math.sqrt(8*s.length + 1) - 1)/2;
		triangle = new int[rows][rows];
		
		int k = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c<= r; c++) {
				triangle[r][c] = s[k];
			  k++;
			  System.out.print(triangle[r][c] + " ");		  
			}
			System.out.println("");
		}
	
		long t1 = System.currentTimeMillis();
		getPathsByBruteForce();
		long t2 = System.currentTimeMillis();
		System.out.println("Time for brute force: " + (t2 -t1));
		
		t1 = System.currentTimeMillis();
		getPaths();
		t2 = System.currentTimeMillis();
		System.out.println("Time for path selection alg: " + (t2 -t1));
	}

	
	private static void getPaths() {		
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
				
		//Start paths at the elements of last row
		for (int c=0; c< rows; c++) {
			List<Integer> path = new ArrayList<Integer>();
			path.add(c);
			paths.add(path);
		}
		
		for (int r = rows-2; r >=0; r--) {
			List<List<Integer>> newPaths = new ArrayList<List<Integer>>();
		   for (int c = 0; c<= r; c++) {	
				List<Integer> p1 = paths.get(c);
				List<Integer> p2 = paths.get(c+1);
			 int sumP1 = getPathSum(p1);
			 int sumP2 = getPathSum(p2);
			 List<Integer> p = (sumP1 > sumP2)?p1:p2;
			 List<Integer> newPath = new ArrayList<Integer>();
			 for (Integer iP: p) newPath.add(iP);			 

			 newPath.add(c);
			 newPaths.add(newPath);
		 }		
		   paths.clear();
		   paths.addAll(newPaths);
	 }
		 printReversePaths(paths);	
	}
	
	private static int getPathSum(List<Integer> path) {
		int sum = 0;
		int r = rows-1;
		for (Integer iP: path) {			
			sum += triangle[r][iP];
			r--;		
		}	
		return sum;
	}
	
	private static void printReversePaths(List<List<Integer>> paths) {
		System.out.println("\nPATHS: \n");
		int maxSum = 0; List<Integer> maxPath = null;
		for (List<Integer> p: paths) {
			int r = rows-1;
			int sum = 0;
			for (Integer iP: p) {
				
				System.out.print(/*r + ", " + iP + ": " + */ triangle[r][iP]+ "; ");
				sum += triangle[r][iP];
				r--;
				if (sum > maxSum) {maxSum = sum; maxPath = p;}
			}
			System.out.print(" sum = " + sum);
			
			System.out.println("");
		}
		System.out.println("maxSum=" + maxSum + "; maxPath: " + maxPath);
    }
	
	

	private static void getPathsByBruteForce() {
		List<Integer> path = new ArrayList<Integer>();
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		
		path.add(0);
		paths.add(path);
		
		for (int r = 1; r < rows; r++) {
			List<List<Integer>> newPaths = new ArrayList<List<Integer>>();
			
			for (List<Integer> p: paths) {
				int lastEl = p.get(p.size()-1);	 
				List<Integer> newPath = new ArrayList<Integer>();
				for (Integer iP: p)
					 newPath.add(iP);
					 
				p.add(lastEl);
				newPath.add(lastEl+1);
				newPaths.add(newPath);
			}
			paths.addAll(newPaths);			
		}
		printPaths(paths);
		
	}
	
	private static void printPaths(List<List<Integer>> paths) {
		System.out.println("\nPATHS: \n");
		int maxSum = 0; List<Integer> maxPath = null;
		
		int l=0;
		for (List<Integer> p: paths) {
			int r = 0;
			int sum = 0;
			for (Integer iP: p) {
				
			//	System.out.print(/*r + ", " + iP + ": " + */ triangle[r][iP]+ "; ");
				sum += triangle[r][iP];
				r++;
				if (sum > maxSum) {maxSum = sum; maxPath = p;}
			}
			l++;
		//	System.out.print(" sum = " + sum);	
		//	if (l%50 == 0) System.out.println("");				
		}
		System.out.println("");	
		System.out.println("maxSum=" + maxSum + "; maxPath: " + maxPath);
    }
	
}
