package Middle;

public class Question2 {
	
	//경로가 없을 경우 나타내 줄 INF 상수에 9999 대입
	final static int INF = 9999;
	
	//문제 2번에 제시된 그래프의 인접 행렬을 생성한다
	int[][] createMatrix() {
		int n = 16;						//정점의 개수 16개
		int graph[][] = new int[n][n];
		
		//인접행렬 graph[][]에 값을 넣어준다		
		for(int i=0; i<graph.length; i++) {
			switch(i) {
			case 0:
				graph[i][i+1] = graph[i][i+4] = 1;
				break;
			case 1:
				graph[i][i+1] = graph[i][i+4] = 2;
				break;
			case 2:
				graph[i][i+1] = graph[i][i+4] = 1;
				break;
			case 3:
				graph[i][i+4] = 3;
				break;
			case 4:
				graph[i][i+1] = graph[i][i+4] = 2;
				break;
			case 5:
				graph[i][i+1] = graph[i][i+4] = 1;
				break;
			case 6:
				graph[i][i+1] = graph[i][i+4] = 4;
				break;
			case 7:
				graph[i][i+4] = 2;
				break;
			case 8:
				graph[i][i+1] = graph[i][i+4] = 3;
				break;
			case 9:
				graph[i][i+1] = graph[i][i+4] = 1;
				break;
			case 10:
				graph[i][i+1] = graph[i][i+4] = 2;
				break;
			case 11:
				graph[i][i+4] = 3;
				break;
			case 12:
				graph[i][i+1] = 2;
				break;
			case 13:
				graph[i][i+1] = 3;
				break;
			case 14:
				graph[i][i+1] = 2;
				break;
			}
		}
		
		//직접 연결된 간선이 존재하지 않는 경우 INF 상수를 넣어준다 
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				if( i != j && graph[i][j] == 0 )
					graph[i][j] = INF;
			}
		}
		
		return graph;
	}
	
	//Floyd알고리즘을 통해 최단 경로 행렬 dist[][]을 구하고 리턴한다
	int[][] floydAlgorithm(int weight[][], int n) {
		//최단 경로를 저장할 행렬 dist[]
		int dist[][] = new int [n][n];
		
		//우선 최단 경로를 저장할 행렬 dist[][]를 가중치 행렬 weight로 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j] = weight[i][j];
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
										dist[start][mid] + dist[mid][end]);
					}
				}
			}
		//최단 경로 행렬 dist를 출력한다
		printMatrix(dist,n);
		//최단 경로 행렬 dist를 리턴한다
		return dist;
	}

	//Floyd알고리즘을 통해 최단 경로 행렬 dist[][]를 구하고
	//그 과정에서 경로 복원을 위한 행렬 path[][]를 구하고 리턴한다
	//path[][]를 리턴받기 위해 메소드를 따로 생성한다
	int[][] floydAlgorithmPath(int weight[][], int n) {
		//최단 경로를 저장할 행렬 dist[][]
		//경로 복원을 위해 해당 도착지로 가기 위해선 어떤 정점을 들려야하는지 저장할 행렬 path[][]
		int dist[][] = new int [n][n];
		int path[][] = new int [n][n];
		
		//floydAlgorithm()과 같이 dist[][]를 가중치 행렬 weight로 초기화
		//path[][]는 다른 정점을 거치지 않는 간선이 있을 경우 (i,j)값을 j로 초기화 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j] = weight[i][j];
				if(dist[i][j] != INF) {
					path[i][j] = j;
				}
			}
		}
		
		//floydAlgorithm()과 동일하게 dist[][]를 구한다
		for (int mid=0; mid<n; mid++) {
			for(int start=0; start<n; start++) {
				for(int end=0; end<n; end++) {
					//정점 k가 정점 i에서 정점 j로 가는 최단 경로상에 있으면
					//dist[i][j]값을 그 경로의 거리로 갱신한다
					//동시에 path[i][j]에 정점 k를 표시한다.
					if(dist[start][mid] + dist[mid][end] < dist[start][end]) {
						dist[start][end] = dist[start][mid] + dist[mid][end];
						path[start][end] = mid;
					}
				}
			}
		}
		
		//path[][]를 리턴한다
		return path;
	}

	//경로를 복원하고 출력한다
	void printPath(int path[][], int start, int end) {
		
		//경로를 추적한 뒤 역순으로 인쇄하기 위해 배열에 저장한다
		int[] printpath = new int[6];		
		int n = end;
		
		System.out.println("		 최소 비용 경로 		");
		System.out.println("*시작점: " + start + "\n*도착점: " + end );
		
		for(int i=0; i<5; i++) {
			printpath[i] = path[start][n];
			n = path[start][n];
		}
		
		System.out.print("*경로: ");
		for(int i=5; i>=0; i--) {
			System.out.print(printpath[i] + "  ");
		}
		
	}
	
	//최소 비용 행렬을 출력한다
	//행렬을 출력하는 print 메소드 
	void printMatrix(int matrix[][], int n) {
		System.out.println("------------------------------------------------");
		System.out.println("		  최단 거리 행렬 		");
		
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
		System.out.println("------------------------------------------------");
	}
	
	
	//시작 메소드 main 
	public static void main(String[] args) {
		
		Question2 a = new Question2(); 		//메소드 사용을 위해 객체 생성 
		
		int[][] originGraph = a.createMatrix(); 	//제시된 행렬 생성 
		
		//최소 비용 경로 생성 및 출력 
		int[][] graph = a.floydAlgorithm(originGraph, 16);
		//경로 복원을 위한 행렬 생성
		int[][] path = a.floydAlgorithmPath(originGraph, 16);
		
		//문제에서 요구하는 0번부터 15번까지의 최소 비용이 되는 경로를 복원하고 출력한다
		a.printPath(path, 0, 15);
	}

}
