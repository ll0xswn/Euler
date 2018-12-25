import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Euler67 {
  
	private static int s[];
	private static int rows =0;
    private static int [][] triangle;
	
	public static void main(String [] args) {	
		getTriangleArray();
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
		getPaths();
		long t2 = System.currentTimeMillis();
		System.out.println("Time for path selection alg: " + (t2 -t1));
	}

	private static void getTriangleArray() {	
	   s = new int[5050];
       try {
    	   FileReader fileReader = new FileReader("C:\\var\\workspace\\TRY\\triangle.txt");
    	   BufferedReader bufferedReader = new BufferedReader(fileReader);    	  
    	   String line = null;
    	   
    	   int nNumbers = 0;
    	   	while ((line = bufferedReader.readLine()) != null) {
	            line=line.trim();
	            String [] numbersInRow = line.split(" ");	           
	            for (String n: numbersInRow) {
	            	s[nNumbers]= (new Integer(n.trim())).intValue();
	            	nNumbers++;
	            }
    	   	}
	     bufferedReader.close();
	     System.out.println("Numbers = " + nNumbers);
       } catch (Exception e){}
	
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
	
}
