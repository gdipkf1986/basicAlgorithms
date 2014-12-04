package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import BinarySearch.BasicBS;
import DataStructure.BasicDS;
import DataStructure.Node;

public class BasicDAC {
	
	public static void main(String[] args){
		
		int[] array = BasicBS.random(7, 1, 30, true);
		
		System.out.println("\n==> peak index in array"+Arrays.toString(array)+" : "+BasicDAC.findAPeakIndex(array, 0, array.length-1));
		
		
		Node root = BasicDS.generateBinaryTree(4, false, true);
		
		BasicDS.printTree(root);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("\n==> preorder without recursion :" + Arrays.toString(BasicDAC.preOrderTraversalWithoutRecursion(root).toArray()));
		System.out.println("\n==> preorder with    recursion :" + Arrays.toString(BasicDAC.preOrderTraversal(root).toArray()));
	}
	
	//http://lintcode.com/en/problem/find-a-peak/
	//http://courses.csail.mit.edu/6.006/spring11/lectures/lec02.pdf
	//http://courses.csail.mit.edu/6.006/spring11/rec/rec02.pdf
	/**
	 * 1. 如何保证一定有一个峰值: array[1] > array[0] && array[end] < array[end-1], 前半段向上, 后半段向下, 题目假设元素不重复
	 * 2. 在 array 中取最中间一个值 m = array[middle], 如果它同时比左右两边的值都大, 它就是峰值 
	 * 3. 否则, 把 m 和它右边的邻值 mr 比较, 以判断它的走势, 如果 mr > m, 说明右边是向上升的, 类似于右斜线 /, 那右边一定有一个峰值, 从mr开始到最后一个结点重复第二步
	 * 4. 如果 mr < m,  说明右边是下降的, 类似于斜线 \, 结合第一条, 那左边一定有一个峰值, 从array[0]到m的前一个结点重复第二步
	 * @param array
	 * @param i
	 * @param j
	 * @return
	 */
	public static int findAPeakIndex(int[] array, int i, int j){
		
		
		if( j == i + 1){
			return array[j] > array[i] ? j : i;
		}else if(j==i){
			return j;
		}
		
		int mid = (i+j)/2;
		
		if(array[mid] > array[mid-1] && array[mid] > array[mid+1]){
			return mid;
		}
		
		if(array[mid+1] > array[mid]){
			return findAPeakIndex(array, mid+1, j);
		}
		
		if(array[mid+1] < array[mid]){
			return findAPeakIndex(array, i, mid-1);
		}
		
		
		return -1;
	}

	public static int findPeakInMatrix(){
		return -1;
	}

	public static List<Integer> preOrderTraversalWithoutRecursion(Node root){
		
		Stack<Node> stack = new Stack<Node>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if(root == null){
			return list;
		}
		
		stack.push(root);
		while(!stack.isEmpty()){
			Node pop = stack.pop();
			list.add((Integer) pop.data);
			
			if(pop.right!=null){
				stack.push(pop.right);
			}

			if(pop.left!=null){
				stack.push(pop.left);
			}
			
		}
		
		return list;
		
	}

	public static List<Integer> preOrderTraversal(Node root){
		
		List<Integer> list = new ArrayList<Integer>();
		
		if(root == null){
			return list;
		}
		
		list.add(root.data);
		list.addAll(preOrderTraversal(root.left));
		list.addAll(preOrderTraversal(root.right));
		
		
		return list;
	}

	public static Node getLowestCommonAncestor(Node n1, Node n2){
		return null;
	}
}
