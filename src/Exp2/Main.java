package Exp2;

/*
 * Experience 2：
 * 将一个（100个点，500条边）的有向图
 * 变成有向无环图（DAG）
 * 提示：用DFS，但不允许用递归
 * 
 * Experience 3：
 * 计算上述DAG的最长路径
 */

public class Main {
	/*
	 * program begin from here
	 */
	public static void main(String[] args) {
		SecondGraph g = new SecondGraph(6);	//new 100 points
		g.randomNewEdge(15);					//new 500 edges
		g.print();								//print chain
		g.destroyAllLoop();					//print chain
		g.destroyAllLoop();					//print chain
		g.destroyAllLoop();
		g.print();
		g.culMaxWayOfDag();
	}

}
