package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import DataStructure.BasicDS;
import DataStructure.Node;

public class PreOrderTraversal {

	public static void main(String[] args) {
		
		Node root = BasicDS.generateBinaryTree(4, false, true);
		BasicDS.printTree(root);
		
		System.out.println("\n==> preorder without recursion :" + Arrays.toString(PreOrderTraversal.preOrderTraversalWithoutRecursion(root).toArray()));
		System.out.println("\n==> preorder with    recursion :" + Arrays.toString(PreOrderTraversal.preOrderTraversal(root).toArray()));

	}

	public static List<Integer> preOrderTraversal(Node root) {

		List<Integer> list = new ArrayList<Integer>();

		if (root == null) {
			return list;
		}

		list.add(root.data);
		list.addAll(preOrderTraversal(root.left));
		list.addAll(preOrderTraversal(root.right));

		return list;
	}

	public static List<Integer> preOrderTraversalWithoutRecursion(Node root) {

		Stack<Node> stack = new Stack<Node>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (root == null) {
			return list;
		}

		stack.push(root);
		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			list.add((Integer) pop.data);

			if (pop.right != null) {
				stack.push(pop.right);
			}

			if (pop.left != null) {
				stack.push(pop.left);
			}

		}

		return list;

	}
}
