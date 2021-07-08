package chapter5;

public class AllPairsShortestPath {
	
	//경로가 없을 경우 나타내 줄 INF 상수에 9999 대입
	final static int INF = 9999;
	
	//최단 경로 행렬 dist[][] 구하기
	void findAllPairShortestPath(int weight[][], int n) {
		int dist[][] = new int [n][n];
		
		//우선 최단 경로를 저장할 행렬 dist[][]를 가중치 행렬 weight로 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j] = weight[i][j];
			}
		}
		
		//모든 정점들을 한 번에 하나씩 중간 정점들의 집합에 추가한다
		//반복 전에는 최단 경로들은  {0, 1, 2, .., k-1}에 있는 정점만을 경유한다
		//반복 후에는 정점 k가 중간 정점들의 집합에 추가되고
		//최단 경로들은  {0,1, 2, .., k}에 있는 정점들만을 경유한다
		for (int mid=0; mid<n; mid++) {
			System.out.print("mid" + mid + "   ");
			//모든 정점들을 한번에 하나씩 시작 정점으로 선택한다
			for(int start=0; start<n; start++) {
				System.out.print("\nstart" + start + "   ");
				//모든 정점들을 위에서 선택된 시작 종점에 대한 목적지 정점으로 선택한다
				for(int end=0; end<n; end++) {
					//정점 k가 정점 i에서 정점 j로 가는 최단 경로상에 있으면
					//dist[i][j]값을 그 경로의 거리로 갱신한다
					System.out.print("\nend" + end + "\n");
					dist[start][end] = Math.min(dist[start][end], dist[start][mid]+dist[mid][end]);
					
					printSolution(dist,n);
				}
			}
		}
		//최단거리 행렬 dist를 출력
		printSolution(dist,n);
	}

	//최단거리 행렬 dist[0 .. n-1, 0 .. n-1]을 출력한다
	void printSolution(int dist[][], int n) {
		int i, j;
		
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				if(dist[i][j]==INF) {
					System.out.print("INF");
				} else {
					System.out.print(dist[i][j] + "  ");
				}
			}
			System.out.println();
		}
	}
	
	//시작 메소드 main 
	public static void main(String[] args) {
		int graph[][] = { {0, INF, 2, INF},
				 		  {1, 0, INF, INF},
				 		  {INF, 8, 0, 3},
				 		  {6, 4, INF, 0}};
		int n=4;
		
		AllPairsShortestPath a = new AllPairsShortestPath();
		
		//최단거리 행렬을 계산한 후 출력
		a.findAllPairShortestPath(graph, n);
		

	}

}
