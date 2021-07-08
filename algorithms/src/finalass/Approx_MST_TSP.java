package finalass;

import java.util.*;

public class Approx_MST_TSP {
	
	final static int INF = 9999;
	
	// 정점 v에 연결된 방문하지 않은 정점들을 깊이 우선 탐색을 이용하여 재귀적으로 방문한다 
	public static void DFS(Node v)
	{
		// 방문하는 정점 v에 대응된 데이터를 출력한다 
		System.out.print(v.info + " ");
		// 정점 v를 '방문함'으로 표기한다 
		v.visited = true;
		//정점v에 인접한 정점들의 연결 목록을 끄집어 낸다 
		List<Node> neighbours = v.getNeighbours();
		//정점v에 인접한 방문하지 않은 모든 정점들에 대해 깊이 우선 탐색을 수행한다
		for (int i = 0; i < neighbours.size(); i++) {
			Node w = neighbours.get(i);
			if (w != null && !w.visited) 
				DFS(w);
		}		
	}
	
	//Prim 알고리즘을 이용해 주어진 그래프의 최소 비용 신장 트리를 구한다
	//매개변수: w - 주어진 그래프를 나타내는 인접 행렬
	//		  n - 그래프 내의 정점들의 수
	public static Node[] primMST(int[][] w, int n) {
	    int[] near = new int[n];
	    boolean[] isblue = new boolean[n];
	    int i, b, minval, newred;
	    // 최소 비용 신장 트리를 인접 목록으로 나타낸다 
	    Node[] mst = new Node[n];
	    for (i = 0; i < n; i++) 
	    	mst[i] = new Node(i);
	    	isblue[0] = false; // 정점 0을 적색 정점으로 초기화한다 
	    	newred = 0;
		
		System.out.println("최소 비용 신장 트리에 포함된 간선 목록 \n");
		System.out.println("간선\t 가중치");
		
		//정점 0을 제외한 모든 정점을 청색으로 가장 가까운 정점을 정점 0으로 초기화
		for (i = 1; i < n; i++) {
	        isblue[i] = true;
	        near[i] = 0; 
	     }
		
		//각 반복에서 한 적색 정점과 한 청색정점을 연결하는 가장 가중치가 작은
		//간선을 선택한 후 그 간선을 최소 비용 신장 트리에 추가
		for (i = 1; i <= n - 1; i++) { 
			minval = INF;
			// 적색 정점들에 가장 가까운 청색 정점을 찾는다 
			for (b = 0; b < n; b++) {
				if(isblue[b])
					if (w[b][near[b]] < minval) {
					    minval = w[b][near[b]];
					    newred = b;
					}
			}
			
			// 청색 정점 newred를 적색으로 변경한다
			isblue[newred] = false;
			
			//최소비용신장트리에 새로이 추가된 간선을 출력한다
			System.out.println(near[newred] + " ~ " + newred + "\t " + w[newred][near[newred]]);
			
			//최소비용신장트리에 새로이 찾은 간선을 추가한다
			mst[near[newred]].addNeighbours(mst[newred]);
			
			//청색 정점에 가장 가까운 적색 정점을 새로이 적색이 된 정점을 반영하여 갱신한다
			for(b=0; b<n; b++) {
				if(isblue[b])
					if(w[b][newred] < w[b][near[b]])
						near[b] = newred;
			}
		}
		return mst;
	}

	public static void main(String[] args) {
		// graph는 완전 그래프
		int graph[][] = new int[][] { {INF, 10, 7, INF, INF, 15},
										{10, INF, INF, 10, 7, INF},
										{7, INF, INF, 7, 10, INF},
										{INF, 10, 7, INF, INF, 5},
										{INF, 7, 10, INF, INF, 12},
										{15, INF, INF, 5, 12, INF} };
		
		Node[] node = new Node[6];
		
		//최소 비용 신장 트리를 구하기 위해 Prim 알고리즘 호출
		node = primMST(graph, 6);
		
		System.out.println("\n깊이 우선 탐색을 이용해 얻은 해밀토니안 회로");
		
		//최소 비용 신장 트리를 깊이 우선 탐색하여 노드들의 방문 순서를 구한다
		DFS(node[0]);
		
		//깊이 우선 탐색으로 얻은 경로에 출발 정점을 추가하여 해밀토니안 회로를 완성
		System.out.println(node[0].info);

	}

}
