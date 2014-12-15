package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Basic.Generator;

public class LevelOrderTraversal {
	
	public static void main(String[] args){
		Node root = Generator.binaryTree(2, true, true);
		root.print();
		
		System.out.println(levelTraversal(root, false));
	}		
	
	public static ArrayList<ArrayList<Integer>> levelTraversal(Node root, Boolean bottomToUp){
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if(root == null) return result;
		
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for(int i=0;i<size;i++){
				Node head = queue.poll();
				level.add(head.data);
				if(head.left!=null){
					queue.offer(head.left);
				}
				if(head.right!=null){
					queue.offer(head.right);
				}
			}
			if(bottomToUp){
				result.add(0, level);
			}else{
				result.add(level);
			}
		}
		
		return result;
	}
}
