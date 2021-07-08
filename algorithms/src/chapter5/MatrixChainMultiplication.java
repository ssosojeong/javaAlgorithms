package chapter5;

public class MatrixChainMultiplication {
	
	//Mi x Mi+1 x ... x Mj를 계산하기 위한 최소 곱셈 횟수를 분할 정복을 이용하여 구함
	static int MatrixMult_DC(int r[], int i, int j) {
		int k;
		
		if(i == j) return 0;
		else {
			int min_val = Integer.MAX_VALUE;
			
			for(k=i; k<j; k++) {
				min_val = Math.max(min_val,
									MatrixMult_DC(r, i, k) + MatrixMult_DC(r, k+1, j) + r[i-1]*r[k]*r[j]);
			}
			
			return min_val;
		}
	}

	//곱할 행렬들의 수는 n이다
	//행렬 Mi, i=1 .. n, 은 r[i-1] x r[i] 행렬이다
	static int MatrixMult_DP(int r[], int n) {
		//프로그램을 단순화하기 위해 배열 m의 첫 행과 첫 열은 사용하지 않음
		int m[][] = new int [n][n];
		
		int i, j, k, len, q;
		
		//행렬이 하나만 있으면 곱할 필요가 없음
		for(i=1; i<n; i++) m[i][i] = 0;
		
		//len은 행렬 곱셈들의 수
		for(len = 1; len < n-1; len++) {
			for(i=1; i<n-len; i++) {
				j = i + len;
				m[i][j] = Integer.MAX_VALUE;
				
				for(k=i; k<j; k++) {
					//q=두개의 행렬 곱으로 분할한 후 곱하는 경우의 최소 곱셈 횟수
					q = m[i][k] + m[k+1][j] + r[i-1]*r[k]*r[j];
					if(q<m[i][j]) m[i][j] = q;
				}
			}
		}
		return m[1][n-1];
	}
	
	//시작 메소드 main
	public static void main(String[] args) {
		int arr[] = {10, 20, 50, 1, 100};
		int size = arr.length;
		
		System.out.println("분할 정복을 이용한 최소 곱셈 횟수: " + MatrixMult_DC(arr, 1, size-1));
		System.out.println("동적 계획을 이용한 최소 곱셈 횟수: " + MatrixMult_DP(arr, size-1));
		
	}

}
