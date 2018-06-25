package Ex7;

import Exp6.MatrixGraph;

public class SeventhGraph extends MatrixGraph{
	public int[] distance;
	public Bellman bellman;
	
	public SeventhGraph(int numOfPoints) {
		super(numOfPoints, true);
		// TODO 自动生成的构造函数存根
	}

	public SeventhGraph(int numOfPoints, int numOfEdges, int minLen, int maxLen) {
		super(numOfPoints, true);
		// TODO 自动生成的构造函数存根
		for(int i=0; i<numOfEdges; i++)
			this.addOneRandomEdge(minLen, maxLen);
	}
	
	public void bellman_ford(int startPoint) {
		bellman = new Bellman(this);
		bellman.init(startPoint);
		for(int i=0; i<n; i++){
			System.out.println("贝尔曼福德relax之第"+(i+1)+"次：");
			bellman.relax();
		}
		System.out.println("负圈检测开始....");
		if(bellman.relax()){
			System.out.println("贝尔曼福德神之提示：该图含有负圈！");
		}else{
			System.out.println("贝尔曼福德神之提示：该图没有负圈。");
		}
	}

}
