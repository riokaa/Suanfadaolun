package Exp6;
import java.util.Random;

/*
 * ÁÚ½Ó¾ØÕóÍ¼Àà
 */
public class MatrixGraph {
	public int[][] matrix;
	public int n;	//points amount
	int edge;	//edge amount
	boolean isDigraph;
	
	public MatrixGraph(int numOfPoints, boolean isDigraph) {
		this.n = numOfPoints;
		this.isDigraph = isDigraph;
		//init matrix
		matrix = new int[n][n];
		for(int i=0; i<n; i++) 
			for(int j=0; j<n; j++)
				matrix[i][j] = 0;
	}
	
	public void addEdge(int u, int v, int len) {
		if(isDigraph) {
			assert(matrix[u][v] == 0);
			matrix[u][v] = len;
		}else {
			assert(matrix[u][v] == 0 && matrix[v][u] == 0);
			matrix[u][v] = len;
			matrix[v][u] = len;
		}
		edge++;
	}
	
	public void addOneRandomEdge(int minLen, int maxLen) {
		Random r = new Random();
		int len = minLen + r.nextInt(maxLen - minLen + 1);
		while(true) {
			int i = r.nextInt(n);
			int j = r.nextInt(n);
			if(matrix[i][j] == 0 && i!=j) {
				this.addEdge(i, j, len);
				break;
			}
		}
	}
	
	public void print() {
		System.out.println("Graph Matrix("+n+" points, "+edge+" edges"+"):");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
}
