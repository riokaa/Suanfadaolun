package Exp4;

import java.awt.Color;

import Exp1.Graph;

public class FourthGraph extends Graph{
	public Color[] color;
	public int[] f;	//f[] store ending time
	public int count;	//DFS计数器
	
	public FourthGraph(int numOfPoints) {
		super(numOfPoints);
		f = new int[numOfPoints];
		color = new Color[numOfPoints];
		this.setAllColorWhite();
	}
	
	/* get DFS ending time f[] */
	private int[] getDfsEndingTime() {
		this.count = 0;
		this.setAllColorWhite();
		/* DFS all white points */
		for(int i=0; i<this.points.length; i++) {
			if(color[i] == Color.WHITE) {
				this.DFS(i);
			}
		}
		
		this.printEndingTime();
		return this.f;
	}
	
	private void DFS(int p) {
		color[p] = Color.GRAY;
		/* DFS all children of p */
		for(int i=1; i<this.points[p].size(); i++) {
			if(color[this.points[p].get(i)] == Color.WHITE) {
				this.DFS(this.points[p].get(i));
			}
		}
		/* set BLACK */
		color[p] = Color.BLACK;
		this.f[p] = count++;
	}
	
	/* print strong components 强连通分支 */
	public void printStrongComponents() {
		FourthGraph gr = this.getReverseGraph();	//graph reverse
		this.getDfsEndingTime();
		int[] fr = new int[this.f.length];	//f[] reverse
		for(int i=0; i<this.f.length; i++) {
			fr[this.f[i]] = i;
		}
		
		gr.count = 0;
		gr.setAllColorWhite();
		System.out.println("Strong components:");
		for(int i=fr.length-1; i>=0; i--) {
			if(gr.color[fr[i]] == Color.WHITE) {
				System.out.print("{");
				gr.DFSWithPrint(fr[i]);
				System.out.println("}");
			}
		}
	}
	
	private void DFSWithPrint(int p) {
		color[p] = Color.GRAY;
		System.out.print(p + ",");
		/* DFS all children of p */
		for(int i=1; i<this.points[p].size(); i++) {
			if(color[this.points[p].get(i)] == Color.WHITE) {
				this.DFSWithPrint(this.points[p].get(i));
			}
		}
		/* set BLACK */
		color[p] = Color.BLACK;
		this.f[p] = count++;	
	}

	/* set all points color white */
	public void setAllColorWhite() {
		for(int i=0; i<this.color.length; i++) {
			this.color[i] = Color.WHITE;
		}
		//System.out.println("Set all points color 'WHITE'.");
	}
	
	/* test : print ending time f[] */
	public void printEndingTime() {
		System.out.println("DFS ending time f[]:");
		for(int i=0; i<this.f.length; i++) {
			System.out.println(i + " : " + this.f[i]);
		}
	}
	
	/* return a reverse graph */
	public FourthGraph getReverseGraph() {
		FourthGraph res = new FourthGraph(this.points.length);
		for(int i=0; i<this.points.length; i++) {
			int u = this.points[i].get(0);
			for(int j=1; j<this.points[i].size(); j++) {
				int v = this.points[i].get(j);
				res.addEdge(v, u);
			}
		}
		System.out.println("Get reverse graph:");
		res.print();
		return res;
	}
}
