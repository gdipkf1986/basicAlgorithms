package BinarySearch;

import Basic.Generator;
import DataStructure.Node;

public class InsertToBinarySearchTree {
	
	public static void main(String[] args){
		Node binarySearchTree = Generator.binarySearchTree();
		binarySearchTree.print();
		Node node = new Node(123);
		recursion(binarySearchTree, node);
		binarySearchTree.print();
		
	}
	
	public static void noRecursion(Node root, Node tobeInsert){
		
	}
	
	public static Node recursion(Node root, Node tobeInsert){
		if(root == null){
			return tobeInsert;
		}
		
		if(tobeInsert.data >= root.data){
			root.right = recursion(root.right, tobeInsert);
		}else if(tobeInsert.data < root.data){
			root.left = recursion(root.left, tobeInsert);
		}
		
		return root;
	}
}
