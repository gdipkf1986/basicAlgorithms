package DataStructure;

public class Node {
	public Node left, right;
	public Integer data;

	public Node(Integer data) {
		this.data = data;
	}
	
	public Node(){
		this.data = Integer.valueOf(100+(int)Math.round(Math.random()*200));
	}
}