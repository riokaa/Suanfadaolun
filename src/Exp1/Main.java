package Exp1;

public class Main {
	/*
	 * 主程序从这里开始运行
	 */
	public static void main(String[] args) {
		System.out.println("要输出的内容");
		Graph g = new Graph(100);//生成100个点
		g.randomNewEdge(3000);//生成3000个边
		g.print();//输出图的邻接链表
		g.getDistanceOfEveryPoints(50);

	}

}
