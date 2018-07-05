package Ex8;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;
import Exp6.MatrixGraph;

/* 无向完全图 */
public class EighthGraph extends MatrixGraph{
	public int[] distance;
	public int[] pai;
	public int[] pai_cache;
	public Stack<Integer> stack;	// 递归的vi值栈
	Color[][] edgeColor;
	
	public EighthGraph(int numOfPoints) {
		super(numOfPoints, false);
		// TODO 自动生成的构造函数存根
		// 完全图k个点就有k(k-1)条边
		int maxEdgeAmount = numOfPoints * (numOfPoints - 1) / 2;
		while(this.edge < maxEdgeAmount) {
			this.addOneRandomEdge(1, 5);
		}
		edgeColor = new Color[n][n];
		this.cleanAllSelectedEdge();
	}
	
	/* 三角形两边之和大于等于第三边检验(此处是大于等于) */
	public boolean triangle_check() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					// 三点不等
					if(i!=j && i!=k && j!=k)
						if(matrix[i][j]+matrix[i][k]<matrix[j][k] || matrix[i][j]+matrix[j][k]<matrix[i][k] || matrix[i][k]+matrix[j][k]<matrix[i][j]) {
							System.out.println("三角形检验失败.");
							return false;
						}
				}
			}
		}
		System.out.println("三角形检验成功.");
		return true;
	}
	/* 不符合三角形的修复 */
	public void triangle_repaire() {
		System.out.println("三角形修复.");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					// 三点不等
					if(i!=j && i!=k && j!=k) {
						if(matrix[i][j]+matrix[i][k]<matrix[j][k]) {
							if(matrix[i][j]<matrix[i][k]) {
								matrix[i][j]++;matrix[j][i]++;
							}else {
								matrix[i][k]++;matrix[k][i]++;
							}
						}else if(matrix[i][j]+matrix[j][k]<matrix[i][k]) {
							if(matrix[i][j]<matrix[j][k]) {
								matrix[i][j]++;matrix[j][i]++;
							}else {
								matrix[j][k]++;matrix[k][j]++;
							}
						}else if(matrix[i][k]+matrix[j][k]<matrix[i][j]) {
							if(matrix[i][k]<matrix[j][k]) {
								matrix[i][k]++;matrix[k][i]++;
							}else {
								matrix[j][k]++;matrix[k][j]++;
							}
						}
					}
				}
			}
		}
	}
	
	/* get以a为序列的路的长度 */
	public int getLength(ArrayList<Integer> a) {
		System.out.println("去重复点遍历圈 Road: " + a);
		int res = 0;
		for(int i=0; i<a.size()-1; i++) {
			res += matrix[a.get(i)][a.get(i+1)];
		}
		System.out.println("Road length = " + res);
		return res;
	}
	
	public void prim(){
		Color[] pointColor = new Color[n];
		for(int i=0; i<n; i++){
			pointColor[i] = Color.WHITE;
		}
		pointColor[0] = Color.BLACK;
		for(int i=0; i<n-1; i++){
			int u = 0, v = 0;
			int minEdge = 999999;
			// for every point
			for(int j=0; j<n; j++){
				if(pointColor[j] == Color.BLACK){
					// for every edge of the point j
					for(int k=0; k<n; k++){
						if(edgeColor[j][k] != Color.BLACK && matrix[j][k]>0 && matrix[j][k]<minEdge){
							u = j;
							v = k;
							minEdge = matrix[j][k];
						}
					}
				}
			}
			// then we get the min edge from black point
			edgeColor[u][v] = Color.BLACK;
			edgeColor[v][u] = Color.BLACK;
			pointColor[v] = Color.BLACK;
		}
	}

	public Tree MSTConstruct(){
		Tree mst = new Tree(n, 0);
		Stack<Integer> st = new Stack<Integer>();

		Color[] seen = new Color[n];
		for (int i=0; i<n; i++) {
			seen[i] = Color.WHITE;
		}
		seen[0] = Color.BLACK;

		st.push(0);

		while(!st.isEmpty()){
			int current = st.pop();
			for(int i=0; i<n; i++){
				if(edgeColor[current][i] == Color.BLACK && seen[i] == Color.WHITE){
					mst.node[current].addChild(mst.node[i]);
					seen[i] = Color.BLACK;
					st.push(i);
				}
			}
		}
		return mst;
	}
	
	public void fk_init() {
		this.distance = new int[n];
		this.pai = new int[n];
		this.pai_cache = new int[n];
		this.stack = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			distance[i] = 999999;
			pai[i] = -1;
		}
	}
	
	public void fk_run() {
		this.fk_init();
		// run from 0
		int[] u = new int[n-1];
		for(int i=1; i<n; i++) {
			u[i-1] = i;
		}
		int res = this.fk(0, u, 0);
//		System.out.print("π = [");
//		for(int i=0; i<n; i++) {
//			System.out.print(pai[i] + ",");
//		}
//		System.out.println("]");
		System.out.println("最短的TSP圈长度 res = "+res);
	}
	
	public int fk(int vi, int[] u, int v1) {
		this.stack.push(vi);
//		System.out.println(stack);
		if(u.length == 0) {
//			System.out.println("↑ 0级min: " + 0);
			this.stack.pop();
			return matrix[vi][v1];
		}else {
			int min = Integer.MAX_VALUE;
			// for every element in u do
			for(int i=0; i<u.length; i++) {
				// delete this element and 递归
				int[] nextu = new int[u.length-1];
				int k = 0;
				for(int j=0; j<u.length; j++) {
					if(j == i) {	// delete element
						continue;
					}else {
						nextu[k] = u[j];
						k++;
					}
				}
				// get min
				int hahaha = matrix[vi][u[i]] + this.fk(u[i], nextu, v1);
//				System.out.println(stack);
				if(hahaha<min) {
					min = hahaha;
					// pai cache set
					pai_cache[u[i]] = vi;
					if(nextu.length == 1) {
						pai_cache[v1] = nextu[0];
					}
					if(u.length == this.n-1) {
						pai = pai_cache.clone();
					}
//					System.out.println("↑ " + u.length + "级min: " + min);
				}
			}
			this.stack.pop();
			return min;
		}
	}
	
	public void cleanAllSelectedEdge(){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				edgeColor[i][j] = Color.WHITE;
			}
		}
	}
}