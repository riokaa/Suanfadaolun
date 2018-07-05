package Ex8;

import java.util.ArrayList;
import java.util.Stack;

public class Tree {
	public Node[] node;
	public Node root;
	
	public Tree(int numOfNode, int root) {
		this.node = new Node[numOfNode];
		for(int i=0; i<numOfNode; i++) {
			this.node[i] = new Node(i);
		}
		this.root = node[root];
	}

	/* 鑾峰彇鍓嶅簭閬嶅巻 */
	public ArrayList<Integer> getDLR(){
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Node> st = new Stack<Node>();
		st.push(this.root);
		while(!st.isEmpty()){
			Node current = st.pop();
			res.add(current.value);
			for(int i=0; i<current.children.size(); i++) {
				st.push(current.children.get(i));
			}
		}
		
		System.out.println("最小生成树的前序遍历: " + res);
		return res;
	}
}

class Node{
	public int value;
	public ArrayList<Node> children;
	
	public Node(int value) {
		this.value = value;
		this.children = new ArrayList<Node>();
	}
	public void addChild(Node child) {
		this.children.add(child);
	}
}