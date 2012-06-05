
public class Euler100 {

	public static void main(String [] args) { 
		//int x =15, y = 6;
		long x =85, y = 35;
	
		//Solve this Diophantine Equation.
		//Found online equation solver
		long z = x*x - y*y - 2*x*y - x + y;//=0
		System.out.println("z= " + z);
		
		double p = x/(x+y) * (x-1)/(x+y -1);
		System.out.println("p= " + p);
		
		
		solveD(1000000000000L);
	}
	
	
	 private static void solveD(long limit) {
		 int P = 5,Q = 2, K = -2,R = 2,S = 1,L = -1;
		 long Xpr=1, Ypr = 0, X=0,Y=0;
		 
		 while ( X + Y < limit) {
		     X = P*Xpr + Q*Ypr + K;
		     Y = R*Xpr + S*Ypr + L;
             Xpr = X; Ypr = Y;
		 }
		 
		 long z = X*X - Y*Y - 2*X*Y - X + Y;
		 System.out.println("X= " + X + ", Y =" + Y + ", Z =" +z + "X+Y= " + (X + Y) );
	 }
}
