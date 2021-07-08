package chapter4;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	private Queue<Node> queue;
	
	public BreadthFirstSearch() {
		queue = new LinkedList<Node>();
	}
	
	public void BFS(Node v) {
		//v를 '방문함'으로 표시한다
		v.visited = true;
		
		//v를 큐에 추가한다
		queue.add(v);
		
		while(!queue.isEmpty()) {
			//큐의 맨 앞에 있는 정점을 끄집어내어 element에 저장한다
			Node element = queue.remove();
			
			//element에 대응된 데이터를 출력한다
			System.out.print(element.info + "  ");
			
			//element에 인접한 정점들의 연결 목록을 끄집어 낸다
			
		}
	}
	
	

	public static void main(String[] args) {
		
		

	}

}
