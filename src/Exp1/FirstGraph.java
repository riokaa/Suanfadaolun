package Exp1;

import java.util.LinkedList;

public class FirstGraph extends Graph{

	public FirstGraph(int numOfPoints) {
		super(numOfPoints);
		// TODO 自动生成的构造函数存根
	}
	
	/* 计算每个点到指定点s的距离 */
	public void getDistanceOfEveryPoints(int n) {
		//存储每个点到点n的距离
		int distance[] = new int[100];
		for(int i=0; i<distance.length; i++) {
			distance[i] = 999999;//初始化每个点的距离为999999
		}
		distance[n] = 0;//点n到n的距离是0
		
		//进行动态规划BFS遍历
		LinkedList<Integer> bfs = new LinkedList<Integer>();
		bfs.add(n);
		while(bfs.size()>0) {
			int bfsPoint = bfs.getFirst();
			for(int i=0; i<this.points[bfsPoint].size(); i++) {
				if(distance[bfsPoint]+1 < distance[this.points[bfsPoint].get(i)]) {
					distance[this.points[bfsPoint].get(i)] = distance[bfsPoint]+1;
					bfs.add(this.points[bfsPoint].get(i));
				}
			}
			bfs.remove(0);
		}
		
		//输出最终结果
		System.out.println("每个点到点"+n+"的距离是：");
		for(int i=0; i<distance.length; i++) {
			System.out.println(i+"："+distance[i]);
		}
	}
}
