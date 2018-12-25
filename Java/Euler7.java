import java.util.ArrayList;
import java.util.List;


public class Euler7 {

	
	public static void main(String [] args) {
		long t1 = System.currentTimeMillis();
		
		
		ArrayList<Integer> primes= eratosthenesPrimeGen(200000);
		
		int l = 0;
		StringBuilder sb = new StringBuilder();
		
		for (Integer p: primes) {
			l++;
			System.out.print(p + ", ");	
			if (l == 10001){
				System.out.println("");
				System.out.println(" 10001 prime is " + p);
				break;
			}
		}
		
		long t2 = System.currentTimeMillis();
		
		System.out.println(l + " Primes for Time: " + (t2-t1));
		
		
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
	
	

}
