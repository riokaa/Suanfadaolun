# README
算法导论实验程序(1804)，包含8个算法实验。

|Aothor|爱吃大板|
|---|---|
|Email|rayiooo@foxmail.com|

## Experience 1

> * 生成一个100个点、3000条边的有向随机图，任选一点为源点，计算s到其它点的距离。
> * 注：图用邻接链表存储。
 
```Java
/* 例程 */
public class Main {
  /*
   * 主程序从这里开始运行
   */
  public static void main(String[] args) {
	  FirstGraph g = new FirstGraph(100);	//生成100个点
	  g.randomNewEdge(500); //生成500个边
	  g.print();  //输出图的邻接链表
  	g.getDistanceOfEveryPoints(50); //计算每个点到50号点的距离
  }
}
 ```
 
## Experience 2
> * 将一个（100个点，500条边）的有向图，变成有向无环图（DAG）。
> * 提示：用DFS，但不允许用递归。

思路：删除从每个点起始的环路最后一条边；用栈实现DFS。
 
## Experience 3
> * 计算上述DAG的最长路径。

思路：从每个点起始，动态规划BFS或DFS获取最长路径，所有点的最长最长路径就是最长路径。
 
 ```Java
 /* 例程 */
 public class Main {
	/*
	 * program begin from here
	 */
	public static void main(String[] args) {
		SecondGraph g = new SecondGraph(100);	//new 100 points
		g.randomNewEdge(500); //new 500 edges
		g.print();  //print chain
		g.destroyAllLoop();
		g.print();
		g.culMaxWayOfDag();
	}
 }
 ```
 
## Experience 4:
> * 找出一个100个点、500条边的有向图的所有强连通分支。

思路：固定算法，原图DFS并保存结束时间f[]，转置图按f[]降序DFS的树的数量就是强连通分支的数量，每颗树的节点都是一个强连通分支。
 
 ```Java
 /* 例程 */
 public class Main {
	public static void main(String[] args) {
		FourthGraph g = new FourthGraph(100);	//new 100 points
		g.randomNewEdge(500); //new 500 edges
		g.print();  //print chain
		g.printStrongComponents();
	}
  }
 ```
 
## Experience 5：
>* 生成1个100个点，300条边的无向图，对于图中的每个连通分支，计算其中的割点。
>* 割点：从连通分支中删除该点，会导致分支不再连通。
>* 提示：对每个连通分支进行DFS，生成DFS搜索树。
>>		割点 <=> 根节点至少有两个孩子
>* 定义：l[v]=min{d[v],d[w]:u是v的后代，w是v的祖先，且(u,w)∈E即(u,w)是返回边}
>>		结点u是割点 <=> (u,v)是树边，且l[v]>=d[u]
>* 可参照problem 22-2。
