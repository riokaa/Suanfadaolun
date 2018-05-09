package Exp2;

import java.util.LinkedList;
import java.util.Stack;
import Exp1.Graph;

public class SecondGraph extends Graph{

	public SecondGraph(int numOfPoints) {
		super(numOfPoints);
	}

	/* destroy the last edge of the loop from pointNum */
	public void destroyLoopFromPoint(int pointNum){
		Stack<Integer> stack = new Stack<Integer>();
		
		//init point colors
		PointColor color[] = new PointColor[this.points.length];
		for(int i=0; i<this.points.length; i++){
			color[i] = PointColor.WHITE;
		}
		
		stack.push(pointNum);
		
		//DFS
		while(!stack.empty()){
			int current = stack.pop();
			//this.printStack(stack);
			if(color[current] == PointColor.BLACK)
				continue;	//if be checked then continue
			for(int i=1; i<this.points[current].size(); i++){
				//System.out.println(points[current].get(i) + "," + color[points[current].get(i)]);
				if(points[current].get(i) == pointNum){
					this.deleteEdge(current, pointNum);
				}else if(color[points[current].get(i)] != PointColor.BLACK){
					stack.push(points[current].get(i));
					//this.printStack(stack);
					color[points[current].get(i)] = PointColor.GRAY;
				}
			}
			color[current] = PointColor.BLACK;
		}
	}
	
	/* change to DAG */
	public void destroyAllLoop(){
		for(int i=0; i<this.points.length; i++){
			this.destroyLoopFromPoint(i);
		}
	}
	
	/* Calculate max way of the DAG from point n*/
	public int[] culMaxWayFrom(int n){
		//store every distance from point n
		int distance[] = new int[100];
		for(int i=0; i<distance.length; i++) {
			distance[i] = -1;	//init -1
		}				
		distance[n] = 0;//点n到n的距离是0
		
		//动归BFS,保留最大距离，与FirstGraph中保留最小距离正好相反
		LinkedList<Integer> bfs = new LinkedList<Integer>();
		bfs.add(n);
		while(bfs.size()>0) {
			int bfsPoint = bfs.getFirst();
			for(int i=1; i<this.points[bfsPoint].size(); i++) {
				if(distance[bfsPoint]+1 > distance[this.points[bfsPoint].get(i)]) {
					distance[this.points[bfsPoint].get(i)] = distance[bfsPoint]+1;
					bfs.add(this.points[bfsPoint].get(i));
				}
			}
			bfs.remove(0);
		}
		
		//get Max distance
		int[] max = this.getMaxInt(distance);
		System.out.println("源自点"+n+"的最长路径是："+n+"-->"+max[1]+"，长度是"+max[0]);
		int[] res = new int[3];
		res[0] = max[0];	//distance
		res[1] = n;	//from
		res[2] = max[1];	//to
		return res;
	}
	
	/* Calculate max way of the DAG all */
	public int culMaxWayOfDag(){
		int[] res = new int[3];
		res[0] = -1;
		for(int i=0; i<this.points.length; i++){
			int[] temp = culMaxWayFrom(i);
			if(temp[0] > res[0]){
				res = temp;
			}
		}
		System.out.println("Distance:"+res[0]+"\tFrom "+res[1]+" to "+res[2]);
		System.out.println("宽鸡儿不要哼歌了！tm听了睡不着");
		return res[0];
	}
	
	/* out print Stack */
	public void printStack(Stack<Integer> s){
		System.out.println(s.toString());
	}
	
	public int[] getMaxInt(int[] a){
		int[] res = new int[2];
		res[0] = a[0];	//length
		res[1] = 0;		//position
		for(int i=1; i<a.length; i++){
			if(a[i] > res[0]){
				res[0] = a[i];
				res[1] = i;
			}
		}
		return res;
	}
}
