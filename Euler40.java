
public class Euler40 {

	public static void main(String[] args) {
		
		Bucket[] buckets = new Bucket[7];
		int d0 = 1,  dmax = 1;
		for (int i=0; i < 7; i++ ) {
			double k = i;
			int n0 = (int) Math.pow(10.0, k);
			int nmax = (int) Math.pow(10.0, i + 1) -1;
			dmax = d0 + (nmax - n0 + 1)*(i +1) - 1;
			System.out.println(i + ": " + n0 + "-" + nmax + ": " + d0 +"-" + dmax);
			
			buckets[i] = new Bucket(n0,nmax,d0,dmax);
			d0 = dmax+1;
		}
		
		/*
		StringBuilder sb = new StringBuilder();
		for (int j = 1; j < 5000000; j++) {
			sb.append(j);
		}
		System.out.println(sb);
		
		int index = 1000000;
	    getChatAtPos(buckets, index);		
	    testPos( sb.toString(),  index-1);
	    */
		
	    int k = 1;
	    for (int i = 1; i < 8; i++) {
	    	getChatAtPos(buckets, k);	
	    	k *=10;
	    }
	   
	}

 
	private static void getChatAtPos(Bucket[] buckets, int index) {
		int number=0, pos =0;
		for (int i=0; i < 7; i++ ) {
			if (index>= buckets[i].d0 && index <= buckets[i].dmax) {
				number = buckets[i].n0 + (index -  buckets[i].d0)/(i+1);
				pos = (index -  buckets[i].d0)%(i+1);
				String nString = number + "";
				System.out.println("Number at index=" + index + " is: " + nString +", " + pos + ":" + nString.charAt(pos));
				break;
			}
				
		}
	  }
	
	 
  private static void testPos(String s, int pos) {
	  //System.out.println(s.charAt(188)+"," + s.charAt(2886-1));
	  System.out.println("TEST: pos=" + pos + ", char: " + s.charAt(pos));
  }
}

class Bucket {
	int d0, dmax, n0, nmax;
	public Bucket(int n0, int nmax, int d0, int dmax) {
		this.n0=n0;
		this.nmax=nmax;
		this.d0=d0;
		this.dmax=dmax;
		
	}
}
