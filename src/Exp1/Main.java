package Exp1;

/*
 * Experience 1：
 * 生成一个100个点、3000条边的有向随机图
 * 任选一点为源点，计算s到其它点的距离
 * 注：图用邻接链表存储
 */

public class Main {
	/*
	 * 主程序从这里开始运行
	 */
	public static void main(String[] args) {
		FirstGraph g = new FirstGraph(100);	//生成100个点
		g.randomNewEdge(500);		//生成500个边
		g.print();					//输出图的邻接链表
		g.getDistanceOfEveryPoints(50);	//计算每个点到50号点的距离

	}

}
