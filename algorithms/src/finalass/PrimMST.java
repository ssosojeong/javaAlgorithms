package finalass;

public class PrimMST {
	final static int INF = 9999;
	
	public static void primMST(int[][] w, int n) {
		int[] near = new int[n];
		boolean[] isblue = new boolean[n];
		int i, b, minval, newred;
		int[][] newGraph = new int[n][n];
		
		for(i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				newGraph[i][j] = 0;
			}
		}
		
		//정점 0을 적색 정점으로 초기화
		isblue[0] = false;
		newred = 0;
		
		System.out.println("최소 비용 신장 트리에 포함된 간선 목록\n");
		System.out.println("간선\t가중치");
		
		//정점 0을 제외한 모든 정점을 청색으로, 가장 가까운 정점을 정점 0으로 초기화
		for(i=1; i<n; i++) {
			isblue[i] = true;
			near[i] = 0;
		}
		
		//각 반복에서 한 적색 정점과 한 청색 정점을 연결하는
		//가장 가중치가 작은 간선을 선택한 후
		//그 간선을 최소 비용 신장 트리에 추가한다
		for(i=1; i<n; i++) {
			minval = INF;
			
			//적색 정점들에 가장 가까운 청색 정점을 찾는다
			for(b=0; b<n; b++) {
				if(isblue[b]) {
					if(w[b][near[b]] < minval) {
						minval = w[b][near[b]];
						newred = b;
					}
				}
			}
			//청색 정점 newred를 적색으로 변경한다
			isblue[newred] = false;
			
			//최소 비용 신장 트리에 새로이 추가된 간선을 출력한다
			System.out.println(near[newred] + " ~ " + newred + "\t" + w[newred][near[newred]]);
			newGraph[near[newred]][newred] = 1;
			newGraph[newred][near[newred]] = 1;
			
			//청색 정점에 가장 가까운 적색 정점을 새로이 적색이 된 정점을 반영하여 갱신한다
			for(b=0; b<n; b++) {
				if(isblue[b]) {
					if(w[b][newred] < w[b][near[b]]){
						near[b] = newred;
					}
				}
			}
		}
	}
	
	

	public static void main(String[] args) {
		int graph[][] = new int[][] { {INF, 10, 7, INF, INF, 15},
										{10, INF, INF, 10, 7, INF},
										{7, INF, INF, 7, 10, INF},
										{INF, 10, 7, INF, INF, 5},
										{INF, 7, 10, INF, INF, 12},
										{15, INF, INF, 5, 12, INF} };
	
		//최소 비용 신장 트리에 포함된 간선들을 찾아서 출력한다
		primMST(graph, 6);

	}

}
