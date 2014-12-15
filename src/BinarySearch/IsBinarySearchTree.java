package BinarySearch;

import Basic.Generator;
import DataStructure.Node;

public class IsBinarySearchTree {


	public static void main(String[] args){
		
		Node binarySearchTree = Generator.binarySearchTree();
		
		binarySearchTree.print();
		
		System.out.println(isBinarySearchTree(binarySearchTree, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	public static boolean isBinarySearchTree(Node root, Integer leftBoard, Integer rightBoard){

		if(root == null) return true;
		
		if(leftBoard > root.data || root.data > rightBoard){
			return false;
		}
		
		if(!isBinarySearchTree(root.left, leftBoard, root.data)){
			return false;
		}
		
		if(!isBinarySearchTree(root.right, root.data, rightBoard)){
			return false;
		}
		
		return true;
	}
}
