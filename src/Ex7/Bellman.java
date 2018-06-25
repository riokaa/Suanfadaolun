package Ex7;

class Bellman{
	SeventhGraph g;

	public Bellman(SeventhGraph g){
		this.g = g;
	}

	public void init(int start){
		g.distance = new int[g.n];
		for (int i=0; i<g.n; i++) {
			g.distance[i] = Integer.MAX_VALUE;
		}
		g.distance[start] = 0;
	}

	public boolean relax(){
		boolean hasRelaxed = false;
		for(int i=0; i<g.n; i++){
			for(int j=0; j<g.n; j++){
				// �?测i点到j点的边并进行relax
				if(g.distance[i] + g.matrix[i][j] < g.distance[j]){
					int newDistance = g.distance[i] + g.matrix[i][j];
					System.out.println("执行Relax("+i+"�?"+j+"): "+g.distance[j]+"�?"+newDistance);
					g.distance[j] = newDistance;
					hasRelaxed = true;
				}else {
					System.out.println("不执行Relax("+i+"�?"+j+").");
				}
			}
		}
		return hasRelaxed;
	}
}