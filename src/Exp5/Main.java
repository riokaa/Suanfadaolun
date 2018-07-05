package Exp5;

/*
 * Exercise 5：
 * 生成1个100个点，300条边的无向图，对于图中的每个连通分支，计算其中的割点。
 * 割点：从连通分支中删除该点，会导致分支不再连通。
 * 提示：对每个连通分支进行DFS，生成DFS搜索树。
 * 		根节点是割点 <=> 根节点至少有两个孩子
 * 定义：l[v]=min{d[v],d[w]:u是v的后代，w是v的祖先，且(u,w)∈E即(u,w)是返回边}
 * 		非根结点u是割点 <=> (u,v)是树边，且l[v]>=d[u]
 * 可参照problem 22-2
 * 
 * 思路：
 * 对于每个节点都进行一次删除，若删除后连通分支没变则不是割点，若连通分支多了1则是割点（暴力解法）。
 */

public class Main {

	public static void main(String[] args) {
		FifthGraph g = new FifthGraph(100);	//new 100 points
		g.randomNewEdge(300);					//new 300 edges
		g.print();								//print chain
		g.printGedian();
	}

}
