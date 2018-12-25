
public class Euler63 {

	
	 public static void main (String args[]) {
		
		 long t1 = System.currentTimeMillis();
		
		 double logs[] = new double[9];
		 for (int b=1 ; b < 10; b++) {
			 logs[b-1] = Math.log10((double) b);
		 }
	
		 int tcount =0;
		 for (int n = 1; n < 22; n++) {
			 int ncount = 0;
			 double ref = (n-1.0)/n ;
			 int interpSrchLoc = (int) Math.floor(Math.pow(10.0, ref));
			// for (int b=1 ; b < 10; b++) {
			//	 double logB = Math.log10((double) b);
		     for (int b=interpSrchLoc ; b < 10; b++) {	 
				 double logB = logs[b-1];
				 if ( logB >= ref ) ncount++;
			 }
			 System.out.println("n=" + n + ", count=" + ncount+  ", interpSrchLoc=" + interpSrchLoc);
			 tcount += ncount;
		 }
		 
		 long t2 = System.currentTimeMillis();
		 t2-=t1;
		 System.out.println("tcount=" + tcount + " for time=" + t2);
	 }
}
