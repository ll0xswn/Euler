

public class Euler1 {

	
	public static void main(String [] args) {
		Long sum3 = 3L*sumOfN(1000L/3L);
		Long sum5 = 5L*sumOfN(1000L/5L -1);
		Long sum15 = 15L*sumOfN(1000L/15L);
		Long nMultof3Or5= sum3 + sum5 - sum15;
		Long nMultof3Or5BF = bfAlg();
		System.out.println("N multiples of 3 or 5: " + nMultof3Or5);
		System.out.println("N multiples of 3 or 5: BF: " + nMultof3Or5BF);
	}
	private static Long sumOfN(Long n){
		return n*(n+1)/2;
	}
	
	private static Long bfAlg() {
		Long sum = 0L;
		for (int i=1; i< 1000; i++){
			if ( (i%3) ==0 || (i%5) ==0)
				sum +=i;
		}
		return sum;
	}
}
