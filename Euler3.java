import java.util.ArrayList;
import java.util.List;


public class Euler3 {

	
	public static void main(String [] args) {
		
		long t1 = System.currentTimeMillis();
		long number = 600851475143L;
		double sqrtN = Math.sqrt((double) number);
		System.out.println(sqrtN );
		
		ArrayList<Integer> primes= eratosthenesPrimeGen(10000);
		
		long prod= 1L;
		StringBuilder sb = new StringBuilder();
		
		for (Integer p: primes) {
			//System.out.print(p + ", ");
			if (number%p ==0) {
				long div= number/p;
				System.out.println( p + " is Factor ; div =  " + div);
				prod *= p;
				sb.append(p + "  * " );
			}
				
			if (prod == number) break;			
		
		}
		
		System.out.println(" prod = " + sb + " = " + prod);
		long t2 = System.currentTimeMillis();
		System.out.println("Time: " + (t2-t1));
		
		t1 = System.currentTimeMillis();
		List<Integer> factors = primeFactors(number);
		for (Integer f: factors) {		
				System.out.print( f + " is Factor; " );		
		}
		t2 = System.currentTimeMillis();
		System.out.println("");
		System.out.println("Time: " + (t2-t1));
	}
	
	private static ArrayList<Integer> eratosthenesPrimeGen(int n) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
        // [1] Create a list of consecutive integers from two to n: (2, 3, 4, ..., n).
        for(int i=2; i<=n; i++)
    	   numbers.add(i);
        int p=2; int k =0;
        while (p*p <=n) {
            k++;
        	//Strike from the list all multiples of p less than or equal to n. (2p, 3p, 4p, etc.)
        	for (int j=2; j<= n/p; j++){
        		int l = p*j;
        	    numbers.remove(new Integer(l));
        	}
        	p = numbers.get(k);
        }
        return numbers;
	}
	
	private static List<Integer> primeFactors(long number) {
		    List<Integer> factors = new ArrayList<Integer>();
		    
		    int d = 2; 
		    while (number > 1){
		        while (number%d==0) {
		            factors.add(d);
		            number /= d;
		        }
		        d = d + 1;
		    }
		return factors;
	}

}
