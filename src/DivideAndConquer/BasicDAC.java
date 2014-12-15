package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

import Basic.Generator;
import DataStructure.Node;
import DataStructure.PreOrderTraversal;

public class BasicDAC {
	
	public static void main(String[] args){
		
		int[] array = Generator.intArray(7, 1, 30, true);
		
		System.out.println("\n==> peak index in array"+Arrays.toString(array)+" : "+FindAPeak.findAPeakIndex(array, 0, array.length-1));
		
		
		Node root = Generator.binaryTree(4, false, true);
		
		root.print();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("\n==> preorder without recursion :" + Arrays.toString(PreOrderTraversal.preOrderTraversalWithoutRecursion(root).toArray()));
		System.out.println("\n==> preorder with    recursion :" + Arrays.toString(PreOrderTraversal.preOrderTraversalRecursion(root).toArray()));
	
	}
	




}
