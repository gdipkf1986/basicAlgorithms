package Basic;

import java.util.Arrays;

import DataStructure.Node;

public class Generator {
	
	public static Integer intArray(Integer min, Integer max){
		
		double random = Math.random();
		while(random==0 || random ==1){
			random = Math.random();
		}
		return (int) (min + (max-min) * random);
	}
	
	public static int[] intArray(int size, Integer min, Integer max, Boolean sorted) {

		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			Integer val = min + (int) Math.round(Math.random() * max);
			result[i] = val;
		}

		if (sorted) {
			Arrays.sort(result);
		}

		return result;

	}

	private static void binarySearchTree(Node root, Integer min, Integer max, Integer depth){
		
		if(depth<1) return;
		
		if(Math.random()>0.1){
			Node left = new Node();
			left.data = intArray(min, root.data);
			root.left = left;
			binarySearchTree(left, min, root.data, depth-1);
		}
		
		if(Math.random()>0.1){
			Node right = new Node();
			right.data = intArray(root.data, max);
			root.right = right;
			binarySearchTree(right, root.data, max, depth-1);
		}
	}
	
	public static Node binarySearchTree(){
		Node root = new Node();
		root.data = 100;
		
		binarySearchTree(root, 1, 150, 3);
		
		return root;
	}
}
