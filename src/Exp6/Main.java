package Exp6;

/*
 * Exercise 6：
 * 用局部搜索算法，求一个无向图的最小生成树。
 * 生成一个无向连通图，有100个点，1000条边，边上的权重是1-20之间的随机整数。
 * 局部搜索算法的基本思路：
 * 1.自己设法得到一棵生成树T。
 * 2.检查不在T上的边，如果加上一条边，生成一个环，并删除一条环上的最大权重的边。
 * 3.重复2，直到所有边都不能优化为止。
 * 用Kruskal或Prim算法求得该图的最小生成树，验证局部搜索算法的对错。
 */

public class Main {

	public static void main(String[] args) {
		SixthGraph g = new SixthGraph(10);	//构造无向图
		for(int i=0; i<20; i++)
			g.addOneRandomEdge(1, 20);
		System.out.println("******原始生成图邻接矩阵******");
		g.print();
		if(g.selectRandomTree()) {
			System.out.println("******随机生成的Tree******");
			g.printSelectedTree();
			System.out.println("******局部搜索操作******");
			g.localSearch();
			System.out.println("******最终生成的MST******");
			g.printSelectedTree();
			// 还差一个验证算法

			// prim
			System.out.println("******Prim算法证明的MST******");
			g.cleanAllSelectedEdge();
			g.prim();
			g.printSelectedTree();
		}
		
	}

}
