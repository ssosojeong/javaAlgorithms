package finalass;

import java.util.List;

public class DepthFirstSearch {
//정점 v에 연결된 방문하지 않은 정점들을 깊이 우선 탐색을 이용하여 재귀적으로 방문

	public static void DFS(Node v) {
		//정점 v에 대응된 데이터를 출력
		System.out.print(v.info + " ");
		
		//정점 v를 '방문함'으로 표기
		v.visited = true;
		
		//정점 v에 인접한 정점들의 연결 목록을 끄집어 냄
		List<Node> neighbours = v.getNeighbours();
		
		//정점 v에 인접한 방문하지 않은 모든 정점들에 대해 깊이우선 탐색 수행
		for(int i=0; i<neighbours.size(); i++) {
			Node w = neighbours.get(i);
			if(w!=null & !w.visited)
				DFS(w);
		}
	}
	
	public static void main(String[] args) {
		//주어진 비방향 그래프를 연결 목록으로 표헌한다
		
		//정점들을 표현한다
		Node[] node = new Node[6];
		
		for(int i=0; i<6; i++)
			node[i] = new Node(i+1);
		
		//간선들을 표현한다
		node[0].addNeighbours(node[1]);
		node[0].addNeighbours(node[2]);
		node[1].addNeighbours(node[4]);
		node[2].addNeighbours(node[3]);
		node[3].addNeighbours(node[5]);

		//주어진 비방향 그래프를 깊이 우선 탐색으로 순회한다
		System.out.println("재귀를 사용한 깊이 우선 탐색 실행 결과");
		DFS(node[0]);
	}

}
