package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import Basic.Generator;

public class Subset {
	public static void main(String[] args) {
		
		int[] array = Generator.intArray(4, 1, 15, true);
		int[] array1 = {1,2,2,3,4};
		
		Arrays.sort(array1);
		
		System.out.println(Arrays.toString(array1));

		ArrayList<ArrayList<Integer>> subsets = dfs_subsets(array1);
		Iterator<ArrayList<Integer>> iterator = subsets.iterator();
		while (iterator.hasNext()) {
			ArrayList<Integer> next = iterator.next();
			System.out.println(next);
		}

	}

	public static ArrayList<ArrayList<Integer>> dfs_subsets(int[] array) {
		ArrayList<ArrayList<Integer>> allSubsests = new ArrayList<ArrayList<Integer>>();
		
		if (array == null || array.length == 0) {
			return allSubsests;
		}
		dfs_subsetHelper(array, 0, allSubsests, new ArrayList<Integer>());

		return allSubsests;

	}

	/**
	 * 深度优先搜索的递归实现, 注意搜索树的构建
	 * @param candidates
	 * @param candidateStartIndex
	 * @param allSubsets
	 * @param currentLvSubset
	 */
	private static void dfs_subsetHelper(int[] candidates, int candidateStartIndex, ArrayList<ArrayList<Integer>> allSubsets, ArrayList<Integer> currentLvSubset) {
		
		//将本分枝结果加入最终结果集  (假设本分枝所在层是第 N 层)
		allSubsets.add(new ArrayList<Integer>(currentLvSubset));

		//搜索下一层所有的分支, 即  N+1 层所有分枝 
		for (int i = candidateStartIndex; i < candidates.length; i++) {
			
			//剪枝: 去掉重复元素, 因为己经排序, 所以只要和前一个元素对比就可以了.
			if (i != candidateStartIndex && candidates[i] == candidates[i - 1]) {
				continue;
			}
			
			currentLvSubset.add(candidates[i]); // currentLvSubset 己经是 N+1 某个分支的结果
			dfs_subsetHelper(candidates, i + 1, allSubsets, currentLvSubset); // 递归的处理 N+1 层
			currentLvSubset.remove(currentLvSubset.size() - 1); // 回退到 N 层, 以便 for 循环进入其它分枝
		}
		
	}
	
}
