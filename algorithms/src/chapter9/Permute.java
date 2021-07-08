package chapter9;

public class Permute {

	public static void main(String[] args) {
		int N = 3;
		int[] A = new int[N];
		
		//<A[0], A[1], ..., A[N-1]>의 모든 순열을 생성한 후 출력한다
		perm(A, 0, N);

	}
	
	//<A[k], A[k+1], ... , A[N-1]>의 모든 순열을 생성한 후 출력한다
	public static void perm(int[] A, int k, int N) {
		int i = 0;
		
		if(k==N) {
			//생성된 순열을 출력한다
			for(i = 0; i<N; i++) {
				System.out.print(A[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//A[k]를 i로 정하기 전에 가능한지 확인한다
		for(i=1; i<=N; i++) {
			if(promising(A, k, i)) {	//A[k]를 i로 정하는 것이 가능한 경우
				A[k] = i;
				//<A[k+1], A[k+2], ... , A[N-1]>의 모든 순열을 생성한다
				perm(A, k+1, N);
			}
		}
	}
	
	//A[k]를 i로 정하는 것이 가능한지 확인한다
	public static boolean promising(int[] A, int k, int i) {
		boolean flag;
		int j;
		
		flag = true;
		j = 0;
		
		//i가 A[0 .. k-1]내의 한 요소와 같으면 A[k]를 i로 정할수 없다고 알려준다.
		//그렇지 않으면 A[k]를 i로 정할 수 있다고 알려준다.
		while(j<k && flag) {
			if(i==A[j]) flag = false;
			j++;
		}
		return flag;
	}

}
