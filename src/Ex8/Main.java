package Ex8;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int numOfPoint = 10;
		EighthGraph g = new EighthGraph(numOfPoint);
		while(!g.triangle_check())
			g.triangle_repaire();
		g.print();
		g.fk_run();
		
		System.out.println("========");
		
		g.prim();
		ArrayList<Integer> loop = g.MSTConstruct().getDLR();
		loop.add(0);
		g.getLength(loop);

		System.out.println("========");
		System.out.println("遍历MST所经过的点，这个环路的长度为MST长度的2倍，");
		System.out.println("而MST长度小于等于TSP圈的长度，所以MST遍历圈的长度小于等于TSP圈长度。");
		System.out.println("根据三角形两边和大于第三遍，去重复点的遍历圈长度小于等于MST遍历圈长度，");
		System.out.println("因此所求环路长度不超过TSP圈长度的2倍。");
	}

}
