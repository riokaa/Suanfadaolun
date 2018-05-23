package Exp2;

/*
 * Experience 2：
 * 将一个（100个点，500条边）的有向图
 * 变成有向无环图（DAG）
 * 提示：用DFS，但不允许用递归
 * 
 * 思路：
 * 删除从每个点起始的环路最后一条边；用栈实现DFS。
 * 
 * Experience 3：
 * 计算上述DAG的最长路径
 * 
 * 思路：
 * 从每个点起始，动态规划BFS或DFS获取最长路径，所有点的最长最长路径就是最长路径。
 */

public class Main {
	/*
	 * program begin from here
	 */
	public static void main(String[] args) {
		SecondGraph g = new SecondGraph(6);	//new 100 points
		g.randomNewEdge(15);					//new 500 edges
		g.print();								//print chain
		g.destroyAllLoop();
		g.print();
		g.culMaxWayOfDag();
	}

}
