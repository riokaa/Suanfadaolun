package Exp4;

/*
 * Experience 4:
 * 找出一个100个点、500条边的有向图的所有强连通分支。
 * 
 * 思路：
 * 固定算法，原图DFS并保存结束时间f[]，转置图按f[]降序DFS的树的数量就是强连通分支的数量，每颗树的节点都是一个强连通分支。
 */
public class Main {

	public static void main(String[] args) {
		FourthGraph g = new FourthGraph(6);	//new 100 points
		g.randomNewEdge(8);					//new 500 edges
		g.print();								//print chain
		g.printStrongComponents();
	}

}
