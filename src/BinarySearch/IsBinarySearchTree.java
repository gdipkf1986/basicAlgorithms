package BinarySearch;

import Basic.BTreePrinter;
import Basic.Generator;
import DataStructure.Node;

public class IsBinarySearchTree {


	public static void main(String[] args){
		
		Node binarySearchTree = Generator.binarySearchTree();
		
		BTreePrinter.printNode(binarySearchTree);
	}
}
