package DataStructure;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public Node left, right;
	public Integer data;

	public Node(Integer data) {
		this.data = data;
	}

	public Node() {
		this.data = 100 + Double.valueOf(Math.random() * 200).intValue() ;
	}

	public void print() {
		System.out.println(this.toString());
	}
	
	public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
		if (right != null) {
			right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), left == null, sb);
		}
		sb.append(prefix).append(isTail ? "└── " : "┌── ").append(data.toString()).append("\n");
		if (left != null) {
			left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
		}
		return sb;
	}

	@Override
	public String toString() {
		return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
	}
}