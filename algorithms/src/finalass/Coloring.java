package finalass;

public class Coloring {
	int N;					//그래프 정점 수
	int m;					//칠할 색 수
	int[] colors;			//정점들에 칠해진 색들의 배열
	
	public void coloring(int G[][], int i) {
		int color;
		if(valid(G, i)){
			if(i==N) { 		//모든 정점에 대한 색칠이 끝나면 출력
				for(i=1; i<=N; i++)
					printTree(i,colors);
				System.out.println();
				return;
			}
			else {			//다음 정점에 색칠을 시도
				for(color = 1; color <=m ; color++) {
					colors[i+1] = color;
					coloring(G, i+1);
				}
			}
		}
	}
	
	public boolean valid(int G[][], int i) {
		int j=1;
		while(j<i) {
			if(G[i-1][j-1] == 1 && colors[i] == colors[j])
				return false;
			j++;
		}
		return true;
	}
	
	public void printTree(int i, int[] colors) {
		switch(i) {
		case 1:
			System.out.print("정점 A = ");
			printColor(i,colors);
			break;
		case 2:
			System.out.print("정점 B = ");
			printColor(i,colors);
			break;
		case 3:
			System.out.print("정점 C = ");
			printColor(i,colors);
			break;
		case 4:
			System.out.print("정점 D = ");
			printColor(i,colors);
			break;
		case 5:
			System.out.print("정점 E = ");
			printColor(i,colors);
			break;
		}
	}

	public void printColor(int i, int[] vcolor) {
		switch(colors[i]) {
		case 1: System.out.print("Red "); break;
		case 2: System.out.print("Green "); break;
		case 3: System.out.print("Blue "); break;
		}
	}
}
