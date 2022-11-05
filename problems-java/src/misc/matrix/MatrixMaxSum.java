package misc.matrix;

/**
 *
 * Find max sum in a matrix using only one value per row and column.
 *
 *      std::vector<std::vector<int>> A = {
 *      {7,53,183,439,863},
 *      {497,383,563,79,973},
 *      {287,63,343,169,583},
 *      {627,343,773,959,943},
 *      {767,473,103,699,303}
 *      };
 *
 *      863 + 383 + 343 + 959 + 767 = 3315;
 *
 */

public class MatrixMaxSum {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {7,53,183,439,863},
                {497,383,563,79,973},
                {287,63,343,169,583},
                {627,343,773,959,943},
                {767,473,103,699,303}
        };

        MatrixMaxSum sol = new MatrixMaxSum();
        int res = sol.maxSum(matrix);
        System.out.println(res);
    }


    public int maxSum(int[][] matrix) {

        return helper(matrix, 0, new boolean[matrix[0].length]);

    }

    private int helper(int[][] matrix, int level, boolean[] visited) {
        if (level == matrix.length) return 0;

        int subproblem = helper(matrix, level+1, visited);
        int currMax = 0;
        int currMaxIdx = -1;
        for (int i=0; i < matrix[level].length; i++) {
            if (visited[i]) continue;
            int curr = matrix[level][i] + currMax;
            if (curr > currMax) {
                currMax = curr;
                if (currMaxIdx > -1) {
                    visited[currMaxIdx] = false;
                }
                currMaxIdx = i;
                visited[i] = true;
            }
        }

        return currMax;

    }

}
