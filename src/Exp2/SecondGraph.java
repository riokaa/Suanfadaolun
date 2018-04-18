package Exp2;

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
	
	/* out print Stack */
	public void printStack(Stack<Integer> s){
		System.out.println(s.toString());
	}
}
