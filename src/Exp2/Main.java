package Exp2;

/*
 * Experience 2：
 * 将一个（100个点，500条边）的有向图
 * 变成有向无环图（DAG）
 * 提示：用DFS，但不允许用递归
 */

public class Main {
	/*
	 * program begin from here
	 */
	public static void main(String[] args) {
		SecondGraph g = new SecondGraph(100);	//new 100 points
		g.randomNewEdge(500);					//new 500 edges
		g.print();								//print chain
		
	}

}
