package Exp1;

import java.util.LinkedList;

/*
 * 邻接链表图类
 */
public class Graph {
	protected LinkedList<Integer> points[];	//chain
	protected int edge;
	
	@SuppressWarnings("unchecked")
	public Graph(int numOfPoints) {
		this.edge = 0;
		//生成 numOfPoints 个点的图
		points = new LinkedList[numOfPoints];
		//每个点设置 header 0~99
		for(int i=0; i<numOfPoints; i++) {
			points[i] = new LinkedList<Integer>();
			points[i].add(i);
		}
	}
	
	/* random new 1 edge */
	public void randomNewOneEdge() {
		int u, v;
		boolean flag = true;
		while(true) {
			//选择两个不同的点u,v
			while(true) {
				u = (int)(Math.random()*100);
				v = (int)(Math.random()*100);
				if(u!=v)
					break;
			}
			//搜索u的邻接链表中是否有v，如果有则重新选点，否则成功
			for(int i=0; i<points[u].size(); i++) {
				if(points[u].get(i)==v) {
					flag = false;
					break;
				}
			}
			//if this edge not exist, then add on
			if(flag) {
				this.addEdge(u, v);
				break;
			}else {
				flag = true;
			}
		}
	}
	
	/* random new n edges */
	public void randomNewEdge(int n) {
		for(int i=0; i<n; i++) {
			this.randomNewOneEdge();
		}
	}
	
	/* out print graph */
	public void print() {
		for(int i=0; i<points.length; i++) {
			for(int j=0; j<points[i].size(); j++) {
				System.out.print(points[i].get(j));
				System.out.print(" ——> ");
			}
			System.out.println();
		}
		System.out.println("This graph has " + this.edge + " edges.");
	}

	/* add 1 edge u-->v */
	public void addEdge(int u, int v){
		this.points[u].add(v);
		this.edge += 1;
		System.out.println("Add Edge (" + u + "," + v + ")");
	}
	
	/* delete 1 edge u-->v */
	public void deleteEdge(int u, int v){
		boolean removed = this.points[u].remove((Integer)v);
		if(removed){
			this.edge -= 1;
			System.out.println("Delete Edge (" + u + "," + v + ")");
		}else{
			System.out.println("Failed to delete Edge (" + u + "," + v + ")");
		}
	}
}
