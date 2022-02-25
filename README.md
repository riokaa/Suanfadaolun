# README
算法导论实验程序(1804)，包含8个算法实验。

<!-- |Aothor|爱吃大板|
|---|---|
|Email|rayiooo@foxmail.com| -->

## Exercise 1

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
 
## Exercise 2
> * 将一个（100个点，500条边）的有向图，变成有向无环图（DAG）。
> * 提示：用DFS，但不允许用递归。

思路：删除从每个点起始的环路最后一条边；用栈实现DFS。
 
## Exercise 3
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
 
## Exercise 4
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
 
## Exercise 5
>* 生成1个100个点，300条边的无向图，对于图中的每个连通分支，计算其中的割点。
>* 割点：从连通分支中删除该点，会导致分支不再连通。
>* 提示：对每个连通分支进行DFS，生成DFS搜索树。
>>		割点 <=> 根节点至少有两个孩子
>* 定义：l[v]=min{d[v],d[w]:u是v的后代，w是v的祖先，且(u,w)∈E即(u,w)是返回边}
>>		结点u是割点 <=> (u,v)是树边，且l[v]>=d[u]
>* 可参照problem 22-2。

## Exercise 6
```java
/*
 * Exercise 6：
 * 用局部搜索算法，求一个无向图的最小生成树。
 * 生成一个无向连通图，有100个点，1000条边，边上的权重是1-20之间的随机整数。
 * 局部搜索算法的基本思路：
 * 1.自己设法得到一棵生成树T。
 * 2.检查不在T上的边，如果加上一条边，生成一个环，并删除一条环上的最大权重的边。
 * 3.重复2，知道所有边都不能优化为止。
 * 用Kruskal或Prim算法求得该图的最小生成树，验证局部搜索算法的对错。
 */
```

## Exercise 7
```java
/*
 * 实验7：已知Bellman-Ford算法能判断一个有向加权图是否含有负权重的圈。
 * 请设计一个算法，从图中找出一个负圈。
 * 图：100个点、500条边，每条边的权重是[-5,5]之间的随机非零整数。
 * 要求：多次生成这样的随机图，直到发现负圈为止。
 */
```

思路：经过n次relax后，若还能relax，则含有负圈。

```java
/* 例程 */
public class Main {

	public static void main(String[] args) {
		SeventhGraph g = new SeventhGraph(100, 500, -5, 5);
		g.bellman_ford(0);
	}

}

```

