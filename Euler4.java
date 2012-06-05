import java.util.TreeMap;


public class Euler4 {
	public static void main(String [] args) {
		String s= "abcdba";//"abba"; //"abcd";
		boolean isP  =isPalindrome(s);	
		System.out.println(s + ":" + isP);
		
		/*
		isP = isPalindrome(9009 +"");
		System.out.println(9009 + ":" + isP);
		isP = isPalindrome(250500 +"");
		System.out.println(250500 + ":" + isP);
		isP = isPalindrome(250052 +"");
		System.out.println(250052 + ":" + isP);
		*/
		
		long t1 = System.currentTimeMillis();
		TreeMap<Integer,String> pals = new TreeMap<Integer,String>();
		
		int pal = 0; boolean isDone = false;
		for (int i = 999; i > 99; i--) {
			if (isDone) break;
		    for (int j = i; j > 99; j--) {			
				int prod = i*j;
				//System.out.println(i + " * " + j + " = " + prod);
				isP = isPalindrome(prod + "");			
				if (isP == true) {
				
					System.out.println("PAL: " + prod + " = " +i + " * " + j );
					
					if (prod >= pal) 
						pal = prod;
				    else {
					    if (i < 899) isDone = true;
					    break;
				    }
				  
				 // pals.put(prod,i+" * "+ j);					
				}
			}			
		}
		for (Integer p: pals.keySet())
			System.out.print(p + ", " +  pals.get(p) + " | " );
		
		System.out.println("PAL: " + pal);
		long t2 = System.currentTimeMillis();
		System.out.println("\nTime: " + (t2-t1));
	}
	
	private static boolean isPalindrome(String  s) {
		int len = s.length(); 
		
		/*
		 * boolean isPalindrome = true;
		for (int i=0, j = len-1; i > len/2 &&j <len/2; i++, j--  ) {
			 if(s.charAt(i) != s.charAt(j)) {
				 isPalindrome = false;
				 break;
			 }
		}
		return isPalindrome;
		*/
		boolean isPalindrome = false;
		int i =0, j = len -1;
		while(s.charAt(i) == s.charAt(j) && i <= len/2 && j >= len/2) {
			i++; j --;
		}
		if (i >= len/2) isPalindrome  = true;
		return isPalindrome;
	}
}
