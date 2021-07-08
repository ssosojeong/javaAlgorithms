package Middle;

public class Question3 {
	
	//경로가 없을 경우 나타내 줄 INF 상수에 9999 대입
	final static int INF = 9999;

	//Floyd알고리즘을 통해 최단 경로 행렬 dist[][]을 구하고 리턴한다
	void floydAlgorithm(int hotel_cost[], int air_cost[][], int n) {
		//최단 경로를 저장할 행렬 dist[]
		int dist[][] = new int [n][n];
		
		//우선 최단 경로를 저장할 행렬 dist[][]를 가중치 행렬 weight로 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j] = air_cost[i][j];
			}
		}
		
		//모든 정점들을 한 번에 하나씩 mid 집합에 추가한다
		for (int mid=0; mid<n; mid++) {
			//모든 정점들을 한번에 하나씩 시작 정점으로 선택한다
			for(int start=0; start<n; start++) {
				//모든 정점들을 위에서 선택된 시작 종점에 대한 목적지 정점으로 선택한다
				for(int end=0; end<n; end++) {
					//정점 k가 정점 i에서 정점 j로 가는 최단 경로상에 있으면
					//dist[i][j]값을 그 경로의 거리로 갱신한다
					dist[start][end] = Math.min(dist[start][end],
										dist[start][mid] + dist[mid][end] + hotel_cost[mid]);
					}
				}
			}
			
		
		//최단거리 행렬 dist를 출력한다
		printMatrix(dist,n);

	}
	
	
	//최소 비용 행렬을 출력한다
	//행렬을 출력하는 print 메소드 
	void printMatrix(int matrix[][], int n) {
		System.out.println("---------------");
		System.out.println("  최소 비용 행렬 ");
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j]==INF) {
					System.out.print("INF");
				} else {
					System.out.print(matrix[i][j] + "  ");
				}
			}
			System.out.println();
		}
		System.out.println("---------------");
	}
	
	
	//시작 메소드 main 
	public static void main(String[] args) {
		
		int n = 5;
		int[][] air_cost = new int [n][n];
		
		for(int i=0; i<air_cost.length; i++) {
			for(int j=0; j<air_cost.length; j++) {
				if(i==j) air_cost[i][j] = 0;
				else air_cost[i][j] = (int) Math.pow((j-i), 2);
				
				}
		}
		
		int[] hotel_cost = {0, 2, 2, 5, 0};
		
		Question3 a = new Question3();
		a.floydAlgorithm(hotel_cost, air_cost, 5);

		
		
		
			}

}
