package DataStructure;

import Basic.BTreePrinter;


public class BasicDS {
	public static void main(String[] args){
	}
	
	public static Node generateBinaryTree(Integer maxDepth, Boolean full, Boolean balanced){
		Node root = new Node();
		root.data = 0;
		return generateBinaryTree(root, maxDepth, full, balanced);
	}
	
	private static Node generateBinaryTree(Node root, Integer maxDepth, Boolean full, Boolean balanced){
		
		if(maxDepth<0) return root;
		
		double leftRandom = Math.random();
		double rightRandom = Math.random();
		
		boolean hasLeft = leftRandom<=0.8;
		boolean hasRight = rightRandom<=0.8;

		if(hasLeft){
			Node left = new Node();
			root.left = left;
			generateBinaryTree(left, maxDepth-1, full, balanced);
		}
		
		if(hasRight || (hasLeft && full)){
			Node right = new Node();
			root.right = right;
			generateBinaryTree(right, maxDepth-1, full, balanced);
		}
		
		return root;
	}
	
	public static void printTree(Node root){
		
		BTreePrinter.printNode(root);
		
	}
}



