package finalass;

//주어진 무방향 그래프에 대한 모든 해밀토니안 회로를 찾는다 
public class Hamiltonian {
	int n; // 그래프의 정점들의 수
	int[] path; // 해밀토니안 회로 내의 정점들을 저장하는 배열
	
	public static void main(String[] args) { 
		Hamiltonian hamil = new Hamiltonian(); 
		hamil.path = new int[10];
		//그래프는 인접 행렬로 나타낸다 
		int[][] G = {{0, 1, 1, 0, 0, 1},
				{1, 0, 0, 1, 1, 0},
				{1, 0, 0, 1,  1, 0},
				{0, 1, 1, 0, 0, 1},
				{0, 1, 1, 0, 0, 1},
				{1, 0, 0, 1, 1, 0}
				}; 
		hamil.n = 6;
		hamil.path[0] = 1; // 시작 정점을 정점 1로 한다
		
		//해밀토니안 회로를 찾아서 출력한다
		hamil.hamiltonian(G, 0); 
	}
	
	// 무방향 그래프 G 내의 모든 해밀토니안 회로를 찾아서 출력한다 
	public void hamiltonian(int G[][], int i) {
		int j;
		
		if (valid(G, i))
			if (i == n - 1) { // 찾은 해밀토니안 회로 path[0..n-1]을 출력한다
				System.out.print("찾은 해밀토니안 회로: "); 
			for (i = 0; i < n; i++)
				System.out.print(path[i] + "->"); 
			System.out.println(path[0]);
			return;
		}
		//i번째로 방문할 정점으로 시작 정점을 제외한 모든 정점을 시도해 본다
			else {
				for (j = 2; j <= n ; j++) {
					path[i + 1] = j ;
					hamiltonian(G, i + 1);
				}
			}
	}
	
	// 경로상의 i번째 정점이 유효한 선택인지 확인한다 
	public boolean valid(int G[][], int i) {
		int j;
		if (i == n - 1 && G[path[n-1] - 1][path[0] - 1] == 0) 
		//마지막 정점이 첫 번째 정점과 인접하지 않은 경우
			return false;
		else if ( i > 0 && G[path[i-1] - 1][path[i] - 1] == 0) 
		// i 번째 정점이 (i-1)번째 정점과 인접하지 않은 경우
			return false;
		else { // i번째 정점이 이미 선택되었는지 확인한다
	        j = 1;
	        while (j < i) {
	           if (path[i] == path[j])
	        	   return false;
	           j++; 
	        }
		}
	    return true;
	}
}
	
	
