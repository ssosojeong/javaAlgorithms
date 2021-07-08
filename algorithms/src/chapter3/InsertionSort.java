package chapter3;

public class InsertionSort {

	public static void main(String[] args) {
		int[] intArray = {45, 89, 67, 92, 53, 74, 26, 80};
	
		System.out.print("정렬 전 배열: ");
		for(int i=0; i<intArray.length; i++) {
			System.out.print(intArray[i] + "  ");
		}
		
		insertionSort(intArray);
		
		System.out.print("\n정렬 후 배열: ");
		for(int i=0; i<intArray.length; i++) {
			System.out.print(intArray[i] + "  ");
		}
	}
	
	public static void insertionSort(int[] A) {
		
		for(int i=1; i<A.length; i++) {
			int insertElement = A[i];
			int j = i-1;
			
			while( j>=0 && A[j]>insertElement ) {
				A[j+1] = A[j];
				j = j-1;
			} 
			//결과적으로 while문은 
			//1. A[i]가 A[0]보다 작아서 맨 왼쪽까지 다 탐색해 j가 -1이 된 경우
			//2. 삽입할 A[i]가 A[j]보다 큰, 즉 A[i]가 삽입될 자리([j+1])를 찾은 경우
			//둘 중 하나가 될 때까지 반복
			
			A[j+1] = insertElement; //삽입			
		}	
	}

}
