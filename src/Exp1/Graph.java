package Exp1;

import java.util.LinkedList;

/*
 * 邻接链表图类
 */
public class Graph {
	LinkedList<Integer> points[];//邻接链表们
	
	/* 构造方法 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Graph(int numOfPoints) {
		//生成 numOfPoints 个点的图
		points = new LinkedList[numOfPoints];
		//每个点设置 header 0~99
		for(int i=0; i<numOfPoints; i++) {
			points[i] = new LinkedList();
			points[i].add(i);
			//System.out.println(points[i].getFirst());
		}
	}
	
	/* 在图中随机生成1个边 */
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
			//如果这个边不存在，那么加上它
			if(flag) {
				points[u].add(v);
				break;
			}else {
				flag = true;
			}
		}
		System.out.println("randomNewOneEdge(" + u + "," + v + ")");
	}
	
	/* 在图中随机生成n个边 */
	public void randomNewEdge(int n) {
		for(int i=0; i<n; i++) {
			this.randomNewOneEdge();
		}
	}
	
	/* 输出图 */
	public void print() {
		for(int i=0; i<points.length; i++) {
			for(int j=0; j<points[i].size(); j++) {
				System.out.print(points[i].get(j));
				System.out.print(" ——> ");
			}
			System.out.println();
		}
	}

	
}
