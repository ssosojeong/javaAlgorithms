package chapter2;

public class BinarySearch {

	public static void main(String[] args) {
		int[] A = {10, 12,13,14,18,20, 25, 27, 30, 35, 40, 45, 47};
		int x = 18;
		int n = A.length;
		int location;
		
		location = binarySearch(A, 0, n-1, x);
		System.out.println(x+ "의 index = " + location);

	}
	// target이 배열 A[first .. last] 내에 있는지를 확인하기 위해 이진 탐색을 사용한다.
	// 매개 변수: 배열 A[first .. last], target(찾는 값)
	// 반환값: 있으면 해당 요소의 인덱스, 없으면 -1
	public static int binarySearch(int[] A, int first, int last, int target){
		int result;
		
		if (first>last) //찾지 못한 경우
			result = 1;
		else
		{
			//중간 요소의 인덱스를 구한다
			//int기 때문에 딱 떨어지지 않으면 정수부만 선택
			int mid = (first + last)/2;
			
			if(target==A[mid]) //target이 중간 요소와 같아 찾은 경우
				result = mid;
			else if (target<A[mid]) //target이 중간 요소보다 작다면, 왼쪽 반에서 찾는다.
				result = binarySearch(A, first, mid-1, target);
			else
				result = binarySearch(A, mid+1, last, target);
			
			
		}
		return result;
		
	}

}
