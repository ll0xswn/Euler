
public class Euler2 {

	private static double golden = 0.5*( Math.sqrt(5.0) + 1);
	private static double sqrt5 =  Math.sqrt(5.0); 
	
	public static void main(String [] args) {
		
		/* Horrific runtime: ca 2^n
		long temp=0L;
		for (long i=1L; i < 11L; i+=1) {
			long t1 = System.currentTimeMillis();
			fibClosedForm(n);
			long t2 = System.currentTimeMillis();
			System.out.println( temp +  ", " + (t2 -t1));			
		}
		*/
		
		System.out.println( "Sum: " + sum(34));
		
		long t1 = System.currentTimeMillis();
		
		long temp=0L;
		long sum = 0L;
		for (int i=3; i < 35; i+=3) {
			temp = (long) Math.floor(fibClosedForm(i));
			sum +=temp;			
			System.out.println( i + ": " + temp );			
		}
		long t2 = System.currentTimeMillis();
		System.out.println( "Sum: " + sum +  ", " + (t2 -t1));
		
		
	}
	
	private static double fibClosedForm(long n) {
		double invGoldPow = Math.pow((1.0 - golden), (double) n);
		double powGolden = Math.pow(golden,  (double) n);
		return (powGolden - invGoldPow)/sqrt5;
	}
	
	private static long fib(long n) {
		if (n==1L) return 1L;
		if (n==2L) return 2L;
		
		return fib(n-1) + fib(n-2);
	}
	
	// O(n) runtime
	private static long sum (int n) {
		int prev=1, prevmin2=0, fib=0;
		long sum=0L;
		int j = 1;
		while ( j <= n) {
			fib = prev + prevmin2;
			if ( fib%2 == 0) sum += fib;
			prevmin2=prev;
			prev=fib;
			j++;
		}
		return sum;
	}
}
