package Ex7;

/*
 * 实验7：已知Bellman-Ford算法能判断一个有向加权图是否含有负权重的圈。
 * 请设计一个算法，从图中找出一个负圈。
 * 图：100个点、500条边，每条边的权重是[-5,5]之间的随机非零整数。
 * 要求：多次生成这样的随机图，直到发现负圈为止。
 */
public class Main {

	public static void main(String[] args) {
		SeventhGraph g = new SeventhGraph(100, 500, -5, 5);
		g.bellman_ford(0);
	}

}
