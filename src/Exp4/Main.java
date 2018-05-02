package Exp4;

/*
 * Experience 4:
 * 找出一个100个点、500条边的有向图的所有强连通分支。
 */
public class Main {

	public static void main(String[] args) {
		FourthGraph g = new FourthGraph(6);	//new 100 points
		g.randomNewEdge(8);					//new 500 edges
		g.print();								//print chain
		g.printStrongComponents();
	}

}
