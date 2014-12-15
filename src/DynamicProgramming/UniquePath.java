package DynamicProgramming;


//http://www.lintcode.com/zh-cn/problem/unique-paths/


public class UniquePath {
	public static void main(String[] args){
		System.out.println(uniquePaths(3, 7));
	}

	
	/***
	 * 
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	 * The robot can only move either down or right at any point in time. 
	 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	 * -----------------------------------------------------
	 * | 1.1 | 1.2 | 1.3 | 1.4 | 1.5 | 1.6 | 1.7 |
	 * | 2.1 |     |     |     |     |     |     |
	 * | 3.1 |     |     |     |     |     | 3.7 |
	 * 
	 */
	public static int uniquePaths(int row, int col){
		if(row == 0 || col == 0){
			return 0;
		}
		
		//sum[x, y] 记录是到达 x, y 这个点一共有多少可能的路径
		int[][] sum = new int[row][col];
		
		for(int i=0; i<row; i++){
			sum[i][0] = 1;
		}
		
		for(int j=0; j<col; j++){
			sum[0][j] = 1;
		}
		
		for(int i=1; i<row; i++){
			for(int j=1; j<col; j++){
				
				// 到达  i, j  这个点只可能是上层一个点向下, 或者是 左边的一个点向右
				// 所以到达 i,j 这个点的可能路径就是上左两种可能路径的和.
				sum[i][j] = sum[i-1][j] + sum[i][j-1];
			}
		}
		
		return sum[row-1][col-1];
	}

	/***
	 * same as uniquePaths, but some of the grid cells are blocked so the path should avoid the cells, caculate the paths. 
	 * @param row
	 * @param col
	 * @return
	 */
	public static int uniquePathsWithObstacle(int[][] grid, int row, int col){
		if(row == 0 || col == 0 || grid.length == 0){
			return 0;
		}
		
		int[][] sum = new int[row][col];
		
		for(int i=0;i<row;i++){
			if(grid[i][0]!=1){
				sum[i][0] = 0;
			}else{
				break;
			}
		}
		for(int j=0;j<col;j++){
			if(grid[0][j]!=1){
				sum[0][j] = 0;
			}else{
				break;
			}
		}
		
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				
				//blocked
				if(grid[i][j]==1){
					sum[i][j] = 0;
				}else{
					sum[i][j] = sum[i-1][j]+sum[i][j-1];
				}
				
			}
		}
		return sum[row-1][col-1];
	}
}
