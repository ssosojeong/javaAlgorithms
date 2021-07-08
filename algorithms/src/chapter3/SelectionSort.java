package chapter3;

public class SelectionSort {

	public static void main(String[] args) {
		int[] intArray = {89, 45, 67, 92, 39, 74, 26, 90};
		
		//정렬 전 배열 출력
		System.out.print("정렬 전 배열: ");
		for(int i=0; i<intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		
		//정렬하기 위해 selectionSort() 호출
		selectionSort(intArray);
		
		//정렬 후 배열 출력 
		System.out.print("\n정렬 후 배열: ");
		for(int i=0; i<intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
	}
	
	public static void selectionSort(int[] A){
		int temp, min;
		
		for(int i=0; i<A.length-1; i++) {
			min = i;
			
			//최소값의 인덱스를 찾아서 min에 저장 
			for(int j=i+1; j<A.length-1; j++) {
				//만약 A[j]가 현재의 최소값인 A[min]보다 작으면 min을 j로 바꿈
				if(A[j]<A[min]) min=j; 
			}
			
			//A[min]과 현재 정렬하려고하는 A[i]와 교환
			temp = A[min];
			A[min] = A[i];
			A[i] = temp;			
		}
	}

}
