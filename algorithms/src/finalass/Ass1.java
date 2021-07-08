package finalass;

public class Ass1 {
	public static void main(String[] args) {
		Coloring col = new Coloring();
		col.colors = new int[6];
		
		int graph1[][] = {{0, 1, 1, 1, 0},
							{1, 0, 1, 0, 1},
							{1, 1, 0, 1, 1},
							{1, 0, 1, 0, 1},
							{0, 1, 1, 1, 0}};
		
		col.N = 5;
		col.m = 3;
		
		col.coloring(graph1,0);
	}
}
