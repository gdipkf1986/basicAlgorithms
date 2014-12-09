package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

import Basic.Generator;
import DataStructure.BasicDS;
import DataStructure.Node;

public class BasicDAC {
	
	public static void main(String[] args){
		
		int[] array = Generator.intArray(7, 1, 30, true);
		
		System.out.println("\n==> peak index in array"+Arrays.toString(array)+" : "+FindAPeak.findAPeakIndex(array, 0, array.length-1));
		
		
		Node root = BasicDS.generateBinaryTree(4, false, true);
		
		BasicDS.printTree(root);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("\n==> preorder without recursion :" + Arrays.toString(PreOrderTraversal.preOrderTraversalWithoutRecursion(root).toArray()));
		System.out.println("\n==> preorder with    recursion :" + Arrays.toString(PreOrderTraversal.preOrderTraversal(root).toArray()));
	
	}
	




}
