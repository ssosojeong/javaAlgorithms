package chapter2;

public class ComputeCumulativeSum {

	public static void main(String[] args) {
		int[] FREQ = {1, 0, 7, 5, 4};
		int[] CUME;
		
		System.out.print("배열 FREQ: ");
		for(int i=0; i<FREQ.length; i++) 
			System.out.print("\t" + FREQ[i]);
		System.out.println();
			
		CUME=ComputeCumulativeSum2(FREQ);
		System.out.print("배열 CUME: ");			
		for(int i=0; i<CUME.length; i++) 
			System.out.print("\t" + CUME[i]);
	}
	
	public static int[] ComputeCumulativeSum2(int[] FREQ) {
		int n=FREQ.length;
		int[] CUME = new int[n];
		
		CUME[0] = FREQ[0];
		for(int i=1; i<n; i++) 
			CUME[i] = CUME[i-1] + FREQ[i];
		
		return CUME;
	}
	
	
	
}
